package gr.unipi.mainpackage.server;

import gr.unipi.mainpackage.server.service.server.MainServer;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class StartUp {

    public static void main(String[] args) {
        // Start the server.
        MainServer mainServer = new MainServer();
        mainServer.listenSocket();
    }
}
