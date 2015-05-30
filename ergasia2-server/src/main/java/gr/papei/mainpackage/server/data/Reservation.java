package gr.papei.mainpackage.server.data;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class Reservation {
    private int customerId;
    private int provoliId;

    public Reservation(int customerId, int provoliId) {
        this.customerId = customerId;
        this.provoliId = provoliId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProvoliId() {
        return provoliId;
    }

    public void setProvoliId(int provoliId) {
        this.provoliId = provoliId;
    }
}
