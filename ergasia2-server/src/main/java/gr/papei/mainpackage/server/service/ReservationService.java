package gr.papei.mainpackage.server.service;

import gr.papei.mainpackage.server.data.*;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ReservationService {
    private int customerId;
    private int provoliId;

    public ReservationService(int customerId, int provoliId) {
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
