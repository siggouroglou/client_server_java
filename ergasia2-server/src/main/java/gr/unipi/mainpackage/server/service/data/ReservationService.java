package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.Customer;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ReservationService {

    public ReservationService() {
    }

    /**
     * Creates a new reservation object.
     * @param provoli The provoli object that will reserver the current customer.
     * @param customer
     * @param user
     * @return The new reservation that will be created.
     */
    public ReservationService makeReservation(ProvoliService provoli, Customer customer, AuthorizedUser user) {
        // Check the arguments.
        if (customer == null || provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Reservation_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Making a reservation for the customer");
        return null;
    }

    /**
     * 
     * @param user
     * @return an array of all the reservations of the current customer.
     */
    public ReservationService[] readAllReservations(AuthorizedUser user) {
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