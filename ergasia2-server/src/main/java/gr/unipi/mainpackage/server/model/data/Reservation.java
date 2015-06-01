package gr.unipi.mainpackage.server.model.data;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.customerId;
        hash = 53 * hash + this.provoliId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.provoliId != other.provoliId) {
            return false;
        }
        return true;
    }
}
