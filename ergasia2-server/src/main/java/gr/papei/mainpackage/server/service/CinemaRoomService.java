package gr.papei.mainpackage.server.service;

import gr.papei.mainpackage.server.data.*;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class CinemaRoomService {

    private int id;
    private boolean is3D;
    private int totalSeats;

    public CinemaRoomService() {
        this.id = -1;
        this.is3D = false;
        this.totalSeats = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}
