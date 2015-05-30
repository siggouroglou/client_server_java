package gr.papei.mainpackage.server.service;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class CinemaRoomService {

    public CinemaRoomService() {
    }
    
    /**
     * Create a new cinema room.
     * @param cinemaRoom The new cinema room that will be created.
     * @return the new cinema room object.
     */
    public CinemaRoomService createCinemaRoom(CinemaRoomService cinemaRoom){
        System.out.println("CinemaRoom created");
        return null;
    }
    
    /**
     * Update an existing cinema room.
     * @param id The id of the cinema room that will be updated.
     * @param cinemaRoom The new cinema room that will replace the existing.
     * @return the new updated cinema room object.
     */
    public CinemaRoomService updateCinemaRoom(int id, CinemaRoomService cinemaRoom){
        System.out.println("CinemaRoom update");
        return null;
    }
    
    /**
     * Delete an existing cinema room.
     * @param cinemaRoom The cinema room that will be deleted.
     * @return The deleted cinema room.
     */
    public CinemaRoomService deleteCinemaRoom(CinemaRoomService cinemaRoom){
        System.out.println("CinemaRoom delete");
        return null;
    }
    
    /**
     * 
     * @return an array with all the existing cinema rooms.
     */
    public CinemaRoomService[] readAllCinemaRooms(){
        System.out.println("read all the CinemaRooms");
        return null;
    }
}
