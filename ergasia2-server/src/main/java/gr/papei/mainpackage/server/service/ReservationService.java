package gr.papei.mainpackage.server.service;

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
     * @return The new reservation that will be created.
     */
    public ReservationService makeReservation(ProvoliService provoli) {
        System.out.println("Making a reservation for the customer");
        return null;
    }

    /**
     * 
     * @return an array of all the reservations of the current customer.
     */
    public ReservationService[] readAllReservations() {
        System.out.println("Reading all the Reservations of the customer");
        return null;
    }
}
