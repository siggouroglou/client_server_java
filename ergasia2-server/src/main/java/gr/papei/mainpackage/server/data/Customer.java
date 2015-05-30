package gr.papei.mainpackage.server.data;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class Customer extends User {

    public Customer() {
        super();
    }

    /**
     * Display to the default output (console) all the available films.
     */
    public void showAvailableFilms() {
        System.out.println("Displaying available Films of the customer:" + getName());
    }

    /**
     * Creates a new reservation object.
     * @param provoli The provoli object that will reserver the current customer.
     * @return The new reservation that will be created.
     */
    public Reservation makeReservation(Provoli provoli) {
        System.out.println("Making a reservation for the customer:" + getName());
        return null;
    }

    /**
     * 
     * @return an array of all the reservations of the current customer.
     */
    public Reservation[] readAllReservations() {
        System.out.println("Reading all the Reservations of the customer:" + getName());
        return null;
    }
}
