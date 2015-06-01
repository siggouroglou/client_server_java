package gr.unipi.mainpackage.client;

import gr.unipi.mainpackage.client.lib.Encryption;
import gr.unipi.mainpackage.client.model.data.Admin;
import gr.unipi.mainpackage.client.model.data.ContentAdmin;
import gr.unipi.mainpackage.client.model.data.Film;
import gr.unipi.mainpackage.client.scenario.AdminLoginScenario;
import gr.unipi.mainpackage.client.scenario.ContentAdminCreateScenario;
import gr.unipi.mainpackage.client.scenario.ContentAdminLoginScenario;
import gr.unipi.mainpackage.client.scenario.FilmCreateScenario;
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
        erotima1();
    }

    private static void erotima1() {
        // Login as admin. This account is created before everything.
        Admin admin = new Admin();
        admin.setName("");
        admin.setUsername("siggouroglou");
        admin.setPassword(Encryption.getHashMD5("qweqwe"));
        Scenario adminLogin = new AdminLoginScenario(admin);

        // Create a ContentAdmin that will create the film.
        ContentAdmin contentAdmin = new ContentAdmin();
        contentAdmin.setName("Content Adminopoulos");
        contentAdmin.setUsername("contentable");
        contentAdmin.setPassword(Encryption.getHashMD5("contentablePass"));
        Scenario contentAdminCreate = new ContentAdminCreateScenario(contentAdmin);
        
        // Login as content admin.
        ContentAdminLoginScenario contentAdminLogin = new ContentAdminLoginScenario(contentAdmin);
        
        // Create the film that will be added from contentAdmin.
        Film film = new Film();
        film.setId(1);
        film.setTitle("Kati trexei me ti Mairi");
        film.setCategory("Commedy");
        film.setDescription("Polu orraia tainia");
        Scenario filmCreate = new FilmCreateScenario(film);

        // Create the request(scenario) list that will be made to the server with the correct sequence.
        List<Scenario> scenarioList = new ArrayList<>(3);
        scenarioList.add(adminLogin);
        scenarioList.add(contentAdminCreate);
        scenarioList.add(contentAdminLogin);
        scenarioList.add(filmCreate);

        // Make the request.
        ClientManager clientManager = new ClientManager(scenarioList);
        clientManager.start();
    }
}
