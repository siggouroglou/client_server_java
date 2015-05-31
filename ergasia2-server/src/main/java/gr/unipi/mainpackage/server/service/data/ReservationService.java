package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.data.Reservation;
import gr.unipi.mainpackage.server.service.fileManager.ReservationDbFileManager;
import java.util.List;

/**
 *
 * Database methods for model Reservation.
 * <br/>
 * Every method name follows a standard convention that is used for Java Reflections calls from request manager.
 * @author siggouroglou@gmail.com
 */
public class ReservationService {
    ReservationDbFileManager dbManager;

    public ReservationService() {
        dbManager = new ReservationDbFileManager();
    }

    /**
     * Creates a new reservation object.
     * @param reservation The reservation object that will reserver the current customer.
     * @param user
     * @return The new reservation that will be created.
     */
    public Reservation createReservation(Reservation reservation, AuthorizedUser user) {
        // Check the arguments.
        if (reservation == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Reservation_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        Reservation reservationNew = dbManager.create(reservation);
        
        return reservationNew;
    }

    /**
     * 
     * @param reservation
     * @param user
     * @return an array of all the reservations of the current customer.
     */
    public List<Reservation> readReservation(Reservation reservation, AuthorizedUser user) {
        // Check the arguments.
        if (user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Reservation_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Reading all the Reservations of the customer");
        return null;
    }
}
