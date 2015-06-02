package gr.unipi.mainpackage.client;

import gr.unipi.mainpackage.client.lib.Encryption;
import gr.unipi.mainpackage.client.model.data.Admin;
import gr.unipi.mainpackage.client.model.data.ContentAdmin;
import gr.unipi.mainpackage.client.model.data.Customer;
import gr.unipi.mainpackage.client.model.data.Film;
import gr.unipi.mainpackage.client.model.data.Provoli;
import gr.unipi.mainpackage.client.scenario.AdminLoginScenario;
import gr.unipi.mainpackage.client.scenario.ContentAdminCreateScenario;
import gr.unipi.mainpackage.client.scenario.ContentAdminLoginScenario;
import gr.unipi.mainpackage.client.scenario.CustomerCreateScenario;
import gr.unipi.mainpackage.client.scenario.CustomerLoginScenario;
import gr.unipi.mainpackage.client.scenario.FilmCreateScenario;
import gr.unipi.mainpackage.client.scenario.FilmSearchScenario;
import gr.unipi.mainpackage.client.scenario.ProvoliCreateScenario;
import gr.unipi.mainpackage.client.scenario.ProvoliSearchScenario;
import gr.unipi.mainpackage.client.scenario.Scenario;
import gr.unipi.mainpackage.client.service.ClientManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class StartUp {

    private static final Logger logger = Logger.getLogger(StartUp.class);

    public static void main(String[] args) {
        // Un comment the answer you prefer.
        // Run the answer for the 1st question of the project.
//        answer1();

        // Run the answer for the 2nd question of the project.
//        answer2();
    }

    private static void answer1() {
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
        final int FILM_COUNT = 20;
        List<Scenario> scenarioCreateFilmList = new ArrayList<>(FILM_COUNT);
        for (int i = 0; i < FILM_COUNT; i++) {
            Film film = new Film();
            film.setId(i);
            film.setTitle("Kati trexei me ti Mairi" + i);
            film.setCategory("Commedy");
            film.setDescription("Polu orraia tainia");
            scenarioCreateFilmList.add(new FilmCreateScenario(film));
        }

        // Create the request(scenario) list that will be made to the server with the correct sequence.
        List<Scenario> scenarioList = new ArrayList<>(FILM_COUNT + 3);
        scenarioList.add(adminLogin);
        scenarioList.add(contentAdminCreate);
        scenarioList.add(contentAdminLogin);
        scenarioList.addAll(scenarioCreateFilmList);

        // Make the request.
        ClientManager clientManager = new ClientManager(scenarioList);
        clientManager.start();
    }

    private static void answer2() {
        // Login as admin. This account is created before everything.
        Admin admin = new Admin();
        admin.setName("");
        admin.setUsername("siggouroglou");
        admin.setPassword(Encryption.getHashMD5("qweqwe"));
        Scenario adminLogin = new AdminLoginScenario(admin);

        // Create the Customer.
        Customer customer = new Customer();
        customer.setName("Content Adminopoulos");
        customer.setUsername("contentable");
        customer.setPassword(Encryption.getHashMD5("contentablePass"));
        Scenario customerCreate = new CustomerCreateScenario(customer);
        
        // Add some Provoli objects.
        final int PROVOLI_COUNT = 20;
        Random randomAvailableSeets = new Random(60);
        List<Scenario> scenarioCreateProvoliList = new ArrayList<>(PROVOLI_COUNT);
        for (int i = 0; i < PROVOLI_COUNT; i++) {
            Provoli provoli = new Provoli();
            provoli.setId(i);
            provoli.setFilmId(i % 3);
            provoli.setCinemaRoomId(-1);// No cinema rooms added.
            provoli.setStartDate(new Date());
            provoli.setEndDate(new Date());
            provoli.setNumberOfReservations(randomAvailableSeets.nextInt());
            provoli.setAvailable(i % 3 == 0);
            scenarioCreateProvoliList.add(new ProvoliCreateScenario(provoli));
        }

        // Login as Customer.
        CustomerLoginScenario customerLogin = new CustomerLoginScenario(customer);

        // Search for a film.
        Film film = new Film();
        film.setTitle("Kati trexei me ti Mairi2");
        Scenario filmSearch = new FilmSearchScenario(film);
        
        // Search for the Provoli of a film.
        Provoli provoli = new Provoli();
        provoli.setFilmId(2);
        Scenario provoliSearch = new ProvoliSearchScenario(provoli);

        // Create the request(scenario) list that will be made to the server with the correct sequence.
        List<Scenario> scenarioList = new ArrayList<>(3);
        scenarioList.add(adminLogin);
        scenarioList.add(customerCreate);
        scenarioList.addAll(scenarioCreateProvoliList);
        scenarioList.add(customerLogin);
        scenarioList.add(filmSearch);
        scenarioList.add(provoliSearch);

        // Make the request.
        ClientManager clientManager = new ClientManager(scenarioList);
        clientManager.start();
    }
    
}
