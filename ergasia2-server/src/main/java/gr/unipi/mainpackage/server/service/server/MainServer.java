package gr.unipi.mainpackage.server.service.server;

import gr.unipi.mainpackage.server.lib.PropertiesUtilities;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 * The server class of the application.
 * <br/>
 * This class could be a singleton.
 * <br/>
 Manages the port opened and creates a ServerManager thread per connection.
 * @author siggouroglou@gmail.com
 */
public class MainServer {

    private static final Logger logger = Logger.getLogger(MainServer.class);

    private ServerSocket server;

    public MainServer() {
        server = null;
    }

    public void listenSocket() {
        // Open the network port.
        try {
            logger.debug("Open the network port.");
            server = new ServerSocket(PropertiesUtilities.getInstance().getInt("server.port", "55555")); // bind to all the nic.
        } catch (Exception ex) {
            logger.fatal("Could not listen on port.", ex);
        }

        // Connect to a host.
        while (true) {
            // Waiting and Manager connections.
            try {
                logger.debug("Waiting for a connection.");
                Socket client = server.accept();

                logger.debug("Manage the connection to another thread.");
                new ServerManager(client).start();
            } catch (Exception ex) {
                logger.fatal("Accept to client failed.", ex);
                break;
            }
        }

        // Close the port.
        try {
            logger.debug("Close the port.");
            server.close();
        } catch (IOException ex) {
            logger.fatal("Trying to close the server port failed.", ex);
        }
    }
}
