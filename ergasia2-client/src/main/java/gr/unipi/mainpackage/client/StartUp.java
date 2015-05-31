package gr.unipi.mainpackage.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
import org.apache.log4j.Logger;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class StartUp {

    private static final Logger logger = Logger.getLogger(StartUp.class);

    public static void main(String[] args) {
        // Try to connect.
        try {
            Socket socket = new Socket("localhost", 55555);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            logger.debug("Sending no 1.");
            out.println("1");
            logger.debug("Sending no 2.");
            out.println("2");
            logger.debug("Sending no 3.");
            out.println("3");
            logger.debug("Sending no 4.");
            out.println("4");
        } catch (UnknownHostException ex) {
            logger.error("NUnknown host: localhost", ex);
        } catch (IOException ex) {
            logger.error("No I/O", ex);
        }
        logger.debug("Completed.");
    }
}
