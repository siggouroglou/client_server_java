package gr.papei.mainpackage.server.service;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ContentAdminService extends UserService {

    public ContentAdminService() {
        super();
    }
    
    /**
     * Creates a new film.
     * @param film The film to be created.
     * @return the new film object.
     */
    public FilmService createFilm(FilmService film){
        System.out.println("Film created");
        return null;
    }
    
    /**
     * Updates an existing film.
     * @param id The id of the film to be updated.
     * @param film The new file that will update the existing.
     * @return the new updated film.
     */
    public FilmService updateFilm(int id, FilmService film){
        System.out.println("Film update");
        return null;
    }
    
    /**
     * Delete an existing film.
     * @param film The film that will be deleted.
     * @return The deleted film.
     */
    public FilmService deleteFilm(FilmService film){
        System.out.println("Film delete");
        return null;
    }
    
    /**
     * 
     * @return an array with all the available films.
     */
    public FilmService[] readAllFilms(){
        System.out.println("read all the Films");
        return null;
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
    
    /**
     * Create a provoli object.
     * @param provoli The provoli object to be created.
     * @return the new provoli object.
     */
    public ProvoliService createProvoli(ProvoliService provoli) {
        System.out.println("Provoli created");
        return null;
    }
    
    /**
     * Update an existing provoli object.
     * @param id The id of the object provoli to be updated.
     * @param provoli The provoli object that will replace the existing.
     * @return The new updated provoli object.
     */
    public ProvoliService updateProvoli(int id, ProvoliService provoli) {
        System.out.println("Provoli updated");
        return null;
    }
    
    /**
     * Delete a provoli object.
     * @param provoli The provoli object that will be deleted.
     * @return the deleted provoli object.
     */
    public ProvoliService deleteProvoli(ProvoliService provoli) {
        System.out.println("Provoli deleted");
        return null;
    }
    
    /**
     * 
     * @return an array of provoli objects.
     */
    public ProvoliService[] readAllProvoli() {
        System.out.println("read all the Provoli");
        return null;
    }

}
