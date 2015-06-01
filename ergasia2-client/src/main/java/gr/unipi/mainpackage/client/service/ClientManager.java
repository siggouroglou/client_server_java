package gr.unipi.mainpackage.client.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.client.lib.PropertiesUtilities;
import gr.unipi.mainpackage.client.model.client.RequestMethod;
import gr.unipi.mainpackage.client.model.client.RequestModel;
import gr.unipi.mainpackage.client.model.client.ResponseModel;
import gr.unipi.mainpackage.client.scenario.Scenario;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ClientManager extends Thread {

    private static final Logger logger = Logger.getLogger(ClientManager.class);
    private int sessionId = -1;

    private List<Scenario> scenarioList;

    public ClientManager(List<Scenario> scenarioList) {
        this.scenarioList = scenarioList;
    }

    @Override
    public void run() {
        for (Scenario scenario : scenarioList) {
            // Opening the connection.
            logger.debug("Opening the connection.");
            try (Socket socket = new Socket(PropertiesUtilities.getInstance().getString("server.host"), PropertiesUtilities.getInstance().getInt("server.port"))) {
                // Get the request object and set the session id.
                RequestModel request = scenario.getRequest();
                request.setSessionId(sessionId);
                
                // Sending the request.
                logger.debug("Sending the request.");
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                Gson gson = new GsonBuilder()
                        .setDateFormat("dd.MM.yyyy")
                        .create();
                output.writeUTF(gson.toJson(request, RequestModel.class));
                output.flush();

                // Receiving the response.
                logger.debug("Receiving the response.");
                DataInputStream input = new DataInputStream(socket.getInputStream());
                ResponseModel response = gson.fromJson(input.readUTF(), ResponseModel.class);
                
                // Manage the response.
                if(request.getMethod() == RequestMethod.LOGIN || request.getMethod() == RequestMethod.LOGOUT) {
                    logger.info("RESPONSE: Session id received - " + response.getSessionId());
                    sessionId = response.getSessionId();
                } else {
                    logger.info("RESPONSE: " + response.getResponse());
                }
            } catch (IOException ex) {
                logger.error("Server connection failed.", ex);
            }
            logger.debug("Completed.");
        }
    }
}
