package gr.unipi.mainpackage.server.service.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.server.lib.PropertiesUtilities;
import gr.unipi.mainpackage.server.lib.signin.SignInAbleUser;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.lib.session.AuthorizationModel;
import gr.unipi.mainpackage.server.lib.session.SessionCache;
import gr.unipi.mainpackage.server.model.server.RequestModel;
import gr.unipi.mainpackage.server.model.server.ResponseErrorModel;
import gr.unipi.mainpackage.server.model.server.ResponseModel;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * This class defines a thread that is managing a request.
 *
 * @author siggouroglou@gmail.com
 */
public class ServerManager extends Thread {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ServerManager.class);

    private final Socket socket;
    private boolean isUp = true;

    public ServerManager(Socket socket) {
        super();
        this.socket = socket;
    }

    /**
     * Main method of this thread.
     * <br/>
     * Executes a request.
     */
    @Override
    public void run() {
        // Check the socket state.
        if (isUp) {
            logger.debug("Check the socket state.");
            if (socket == null) {
                logger.fatal("Socket is null");
                isUp = false;
            }
        }

        // Read the request.
        RequestModel request = null;
        if (isUp) {
            request = readRequest();
        }

        // Manage the command.
        ResponseModel response = null;
        if (isUp) {
            response = manageRequest(request);
        }

        // Send response.
        if (isUp) {
            sendResponse(response);
        }

        // Close the connection.
        if (isUp) {
            closeRequest();
        }
    }

    /**
     * This method convert the String request to a RequestModel object.
     *
     * @return
     */
    private RequestModel readRequest() {
        RequestModel request = null;

        // Read the socket.
        logger.debug("Reading the request.");
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            Gson gson = new GsonBuilder()
                    .setDateFormat("dd.MM.yyyy")
                    .create();

            request = gson.fromJson(input.readUTF(), RequestModel.class);
        } catch (Exception ex) {
            logger.error("Not valid request.", ex);
            sendError("Not valid request.");
            closeRequest();
            isUp = false;
        }

        return request;
    }

    /**
     * Identifies the type of the request and calls the appropriate method to
     * continue.
     *
     * @param request The request that will be identified.
     * @return
     */
    private ResponseModel manageRequest(RequestModel request) {

        // Get the model and service instances using Java Reflection.
        logger.debug("Get the model and service instances.");
        Object serviceInstance = null;
        Object modelInstance = null;
        try {
            // Get the service instance.
            serviceInstance = Class.forName("gr.unipi.mainpackage.server.service.data." + request.getEntityName() + "Service")
                    .getConstructor()
                    .newInstance();

            // Get the model instance.
            Gson gson = new GsonBuilder()
                    .setDateFormat("dd.MM.yyyy")
                    .create();
            modelInstance = gson.fromJson(request.getModel(), Class.forName("gr.unipi.mainpackage.server.model.data." + request.getEntityName()));
        } catch (Exception ex) {
            logger.fatal("Request entity was not valid.", ex);
            sendError("Request entity was not valid.");
            closeRequest();
            isUp = false;
            return null;
        }

        // Continue by running the correct method.
        switch (request.getMethod()) {
            case LOGIN:
            case LOGOUT:
                logger.debug("Login/out method detected.");
                return manageRequest_auth(request, serviceInstance, modelInstance);
            case SEARCH:
            case CREATE:
            case READ:
            case UPDATE:
            case DELETE:
                logger.debug("Data management method detected.");
                return manageRequest_data(request, serviceInstance, modelInstance);
        }

        return null;
    }

    /**
     * Executes the request that is managing the login and logout of the
     * application.
     *
     * @param request
     * @param serviceInstance
     * @param modelInstance
     * @return
     */
    private ResponseModel manageRequest_auth(RequestModel request, Object serviceInstance, Object modelInstance) {
        // Get the method to run using Java Reflection.
        logger.debug("Get the login/out method.");
        Method method = null;
        try {
            method = serviceInstance.getClass().getMethod(request.getMethod().toString(), SignInAbleUser.class);
        } catch (NoSuchMethodException | SecurityException ex) {
            logger.fatal("Request method was not valid.", ex);
            sendError("Request method was not valid.");
            closeRequest();
            isUp = false;
            return null;
        }

        // Wrap the output to Reponse model by running the method using Java Reflection.
        logger.debug("Wrap the output to Reponse model.");
        ResponseModel response = null;
        try {
            // Get the returned object.
            Object invoke = method.invoke(serviceInstance, modelInstance);

            // Check if this user is logged in successfully.
            int sessionId = -1;
            if (invoke != null && invoke instanceof AuthorizedUser) {
                sessionId = SessionCache.getInstance().loginUser((AuthorizedUser) invoke);
            }

            response = new ResponseModel();
            response.setSessionId(sessionId);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            logger.fatal("Request method was not valid while requested to run.", ex);
            sendError("Request method was not valid while requested to run.");
            closeRequest();
            isUp = false;
            return null;
        }

        return response;
    }

    /**
     * Executes the request that is managing the data.
     * <br/>
     * Only available for search/create/read/update/delete request methods.
     *
     * @param request
     * @param serviceInstance
     * @param modelInstance
     * @return
     */
    private ResponseModel manageRequest_data(RequestModel request, Object serviceInstance, Object modelInstance) {
        // Get the user that requested this.
        SessionCache sessionCache = SessionCache.getInstance();
        AuthorizationModel authorizationModel = sessionCache.findBySessionId(request.getSessionId());
        AuthorizedUser authorizedUser = authorizationModel.getAuthorizedUser();

        // Allow with login or not.
        if (PropertiesUtilities.getInstance().getBoolean("server.allowWithLogin", "false")) {
            // Check if user is logged in.
            logger.debug("Check if user is logged in.");
            if (authorizedUser == null) {
                logger.fatal("User is not logged in.");
                sendError("User is not logged in.");
                closeRequest();
                isUp = false;
                return null;
            }

            // Check if this users session is expired.
            if (sessionCache.isExpired(request.getSessionId())) {
                logger.fatal("Your session is expired.");
                sendError("Your session is expired.");
                closeRequest();
                isUp = false;
                return null;
            }
        }

        // Get the method to run using Java Reflection.
        logger.debug("Get the data management method.");
        Method method = null;
        try {
            method = serviceInstance.getClass().getMethod(request.getMethod().toString() + request.getEntityName(), modelInstance.getClass(), AuthorizedUser.class);
        } catch (NoSuchMethodException | SecurityException ex) {
            logger.fatal("Request method was not valid.", ex);
            sendError("Request method was not valid.");
            closeRequest();
            isUp = false;
            return null;
        }

        // Wrap the output to Reponse model by running the method using Java Reflection.
        logger.debug("Wrap the output to Reponse model.");
        ResponseModel response = new ResponseModel();
        try {
            // Get the returned object.
            Object invoke = method.invoke(serviceInstance, modelInstance, authorizedUser);

            // Manage the response.
            Gson gson = new GsonBuilder()
                    .setDateFormat("dd.MM.yyyy")
                    .create();
            response.setResponse(gson.toJson(invoke));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            logger.fatal("Request method was not valid while requested to run.", ex);
            sendError("Request method was not valid while requested to run.");
            closeRequest();
            isUp = false;
            return null;
        }

        return response;
    }

    /**
     * Sending the response to the client.
     *
     * @param response The response that will be send.
     */
    private void sendResponse(ResponseModel response) {
        // Get the model as json.
        Gson gson = new Gson();
        String responseJson = gson.toJson(response, ResponseModel.class);

        // Send the response to client.
        logger.debug("Sending response.");
        try {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(responseJson);
            output.flush();
        } catch (IOException ex) {
            logger.fatal("Sending response FAILED ( " + responseJson + ")", ex);
            isUp = false;
        }
    }

    /**
     * Sending an error message as response to the client.
     *
     * @param errorMessage The error message that will be send.
     */
    private void sendError(String errorMessage) {
        // Create the error message model.
        ResponseErrorModel response = new ResponseErrorModel();
        response.setErrorMessage(errorMessage);

        // Get the model as json.
        Gson gson = new Gson();
        String responseJson = gson.toJson(response, ResponseErrorModel.class);

        // Send response.
        logger.debug("Sending an error message: " + errorMessage);
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.write(responseJson);
        } catch (IOException ex) {
            logger.fatal("Sending an error message FAILED: " + responseJson, ex);
            isUp = false;
        }
    }

    /**
     * Closes the current request.
     */
    private void closeRequest() {
        logger.debug("Close the connection.");
        try {
            socket.close();
        } catch (IOException ex) {
            logger.fatal("Closing the connection FAILED.", ex);
            isUp = false;
        }
    }

}
