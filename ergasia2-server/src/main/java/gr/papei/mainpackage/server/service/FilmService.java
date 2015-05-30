package gr.papei.mainpackage.server.service;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class FilmService {

    public FilmService() {
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
     * Display to the default output (console) all the available films.
     */
    public void showAvailableFilms() {
        System.out.println("Displaying available Films of the customer");
    }
}
