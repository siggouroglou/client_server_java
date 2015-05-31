package gr.unipi.mainpackage.client.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.client.lib.PropertiesUtilities;
import gr.unipi.mainpackage.client.model.client.RequestModel;
import gr.unipi.mainpackage.client.scenario.Scenario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ClientManager extends Thread {

    private static final Logger logger = Logger.getLogger(ClientManager.class);

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
                // Sending the request.
                logger.debug("Sending the request.");
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                Gson gson = new GsonBuilder()
                        .setDateFormat("dd.MM.yyyy")
                        .create();
                writer.println(gson.toJson(scenario.getRequest(), RequestModel.class));

                // Receiving the response.
                logger.debug("Receiving the response.");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                System.out.println(reader.readLine());
            } catch (IOException ex) {
                logger.error("Server connection failed.", ex);
            }
            logger.debug("Completed.");
        }
    }
}
