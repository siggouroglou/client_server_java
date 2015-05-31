package gr.unipi.mainpackage.server.model;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class CinemaRoom {

    private int id;
    private boolean support3D;
    private int totalSeats;

    public CinemaRoom() {
        this.id = -1;
        this.support3D = false;
        this.totalSeats = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSupport3D() {
        return support3D;
    }

    public void setSupport3D(boolean support3D) {
        this.support3D = support3D;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}
