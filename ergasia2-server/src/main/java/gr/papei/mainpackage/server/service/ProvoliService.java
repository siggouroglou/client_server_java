package gr.papei.mainpackage.server.service;

import gr.papei.mainpackage.server.data.*;
import java.util.Date;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ProvoliService {
    private int id;
    private int filmId;
    private int cinemaRoomId;
    private Date startDate;
    private Date endDate;
    private int numberOfReservations;
    private boolean isAvailable;

    public ProvoliService() {
        this.id = -1;
        this.filmId = -1;
        this.cinemaRoomId = -1;
        this.startDate = null;
        this.endDate = null;
        this.numberOfReservations = 0;
        this.isAvailable = false;
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

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
