package gr.unipi.mainpackage.client.model.data;

import java.util.Date;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class Provoli {
    private int id;
    private int filmId;
    private int cinemaRoomId;
    private Date startDate;
    private Date endDate;
    private int numberOfReservations;
    private boolean available;

    public Provoli() {
        this.id = -1;
        this.filmId = -1;
        this.cinemaRoomId = -1;
        this.startDate = null;
        this.endDate = null;
        this.numberOfReservations = 0;
        this.available = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCinemaRoomId() {
        return cinemaRoomId;
    }

    public void setCinemaRoomId(int cinemaRoomId) {
        this.cinemaRoomId = cinemaRoomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfReservations() {
        return numberOfReservations;
    }

    public void setNumberOfReservations(int numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean isAvailable) {
        this.available = isAvailable;
    }
}
