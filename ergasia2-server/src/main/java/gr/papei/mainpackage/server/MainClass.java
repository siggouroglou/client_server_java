package gr.papei.mainpackage.server;

import com.google.gson.Gson;
import gr.papei.mainpackage.server.data.model.Admin;
import gr.papei.mainpackage.server.data.model.ContentAdmin;
import gr.papei.mainpackage.server.data.model.Film;
import gr.papei.mainpackage.server.data.model.CinemaRoom;
import gr.papei.mainpackage.server.data.model.Customer;
import gr.papei.mainpackage.server.data.model.Provoli;
import gr.papei.mainpackage.server.data.model.Reservation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class MainClass {

    public static void main(String[] args) {
        // Create Admin.
        Admin admin = new Admin();
        admin.setName("Xrusa");
        admin.setUsername("xrusa");
        admin.setPassword("xrusa87");

        // The admin creates a contentAdmin.
        ContentAdmin contentAdmin = new ContentAdmin();
        contentAdmin.setName("Athina");
        contentAdmin.setUsername("athina");
        contentAdmin.setPassword("athina91");
//        admin.createUser(contentAdmin);

        // Create Customer.
        Customer customer = new Customer();
        customer.setName("Panagiotis Dodekatos");
        customer.setUsername("panagiotis");
        customer.setPassword("panagiotis88");
//        admin.createUser(customer);

        // ContentAdmin creates a Film.
        Film film = new Film();
        film.setId(1);
        film.setTitle("Taken 3");
        film.setCategory("Action");
        film.setDescription("Very good film.");
//        contentAdmin.createFilm(film);

        // ContentAdmin creates a CinemaRoom.
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setId(1);
        cinemaRoom.setIs3D(true);
        cinemaRoom.setTotalSeats(15);
//        contentAdmin.createCinemaRoom(cinemaRoom);

        // Create a Provoli object.
        Provoli provoli = new Provoli();
        provoli.setId(1);
        provoli.setFilmId(1);
        provoli.setCinemaRoomId(1);
        provoli.setStartDate(new Date());
        provoli.setEndDate(new Date());
        provoli.setNumberOfReservations(0);
        provoli.setIsAvailable(true);
//        contentAdmin.createProvoli(provoli);

        // Add a reservation for the created customer.
//        Reservation reservation = customer.makeReservation(provoli);

        // Export to file.
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("output.txt"))) {
            writeObjectToOutput(fileOutputStream, admin, Admin.class);
            writeObjectToOutput(fileOutputStream, contentAdmin, ContentAdmin.class);
            writeObjectToOutput(fileOutputStream, customer, Customer.class);
            writeObjectToOutput(fileOutputStream, film, Film.class);
            writeObjectToOutput(fileOutputStream, cinemaRoom, CinemaRoom.class);
            writeObjectToOutput(fileOutputStream, provoli, Provoli.class);
//            writeObjectToOutput(fileOutputStream, reservation, Reservation.class);
            System.out.println("All the objects saved to file successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void writeObjectToOutput(FileOutputStream fileOutputStream, Object object, Class clazz){
        Gson gson = new Gson();
        String output = gson.toJson(object, clazz);
        try {
            fileOutputStream.write(output.getBytes("utf-8"));
            fileOutputStream.write("\n".getBytes("utf-8")); // New line.
            System.out.println("Object saved to file successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
