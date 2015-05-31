package gr.unipi.mainpackage.server.service;

import gr.unipi.mainpackage.server.lib.PropertiesUtilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class MainServer {

    public void listenSocket() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PropertiesUtilities.getInstance().getInt("server.port", "55555"));
        } catch (Exception e) {
            System.out.println("Could not listen on port 4321");
            System.exit(-1);
        }
//        listenSocketSocketserver.acceptSocket
        Socket client = null;
        try {
            client = server.accept();
        } catch (Exception e) {
            System.out.println("Accept failed: 4321");
            System.exit(-1);
        }
//        listenSocketBufferedReaderclientPrintWriter
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            while (true) {
                try {
                    String line = in.readLine();
//Send data back to client
                    out.println(line);
                } catch (IOException e) {
                    System.out.println("Read failed");
                    System.exit(-1);
                }
            }
        } catch (Exception e) {
            System.out.println("Read failed");
            System.exit(-1);
        }
    }
}
