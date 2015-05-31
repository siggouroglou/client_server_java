package gr.unipi.mainpackage.client;

import gr.unipi.mainpackage.client.lib.Encryption;
import gr.unipi.mainpackage.client.model.data.Admin;
import gr.unipi.mainpackage.client.scenario.AdminCreateScenario;
import gr.unipi.mainpackage.client.scenario.Scenario;
import gr.unipi.mainpackage.client.service.ClientManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class StartUp {

    private static final Logger logger = Logger.getLogger(StartUp.class);

    public static void main(String[] args) {
        // Create the admin scenatio.
        Admin admin = new Admin();
        admin.setName("George Siggouroglou");
        admin.setUsername("siggouroglou");
        admin.setPassword(Encryption.getHashMD5("qweqwe"));
        
        List<Scenario> scenarioList = new ArrayList<>(1);
        scenarioList.add(new AdminCreateScenario(admin, 1));
        
        // Make the request.
        ClientManager clientManager = new ClientManager(scenarioList);
        clientManager.start();
    }
}
