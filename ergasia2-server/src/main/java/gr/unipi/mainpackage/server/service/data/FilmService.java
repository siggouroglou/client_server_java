package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.data.Film;
import gr.unipi.mainpackage.server.service.fileManager.FilmDbFileManager;
import java.util.List;

/**
 *
 * Database methods for model Film.
 * <br/>
 * Every method name follows a standard convention that is used for Java Reflections calls from request manager.
 * @author siggouroglou@gmail.com
 */
public class FilmService {
    FilmDbFileManager dbManager;

    public FilmService() {
        dbManager = new FilmDbFileManager();
    }

    /**
     * Search for a film.
     *
     * @param film The film to be searched for.
     * @param user
     * @return the new film object.
     */
    public List<Film> searchFilm(Film film, AuthorizedUser user) {
        // Check the arguments.
        if (film == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_S, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        List<Film> filmFoundList = dbManager.search(film);
        
        return filmFoundList;
    }

    /**
     * Creates a new film.
     *
     * @param film The film to be created.
     * @param user
     * @return the new film object.
     */
    public Film createFilm(Film film, AuthorizedUser user) {
        // Check the arguments.
        if (film == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        Film filmNew = dbManager.create(film);
        
        return filmNew;
    }

    /**
     * Updates an existing film.
     *
     * @param id The id of the film to be updated.
     * @param film The new file that will update the existing.
     * @param user
     * @return the new updated film.
     */
    public Film updateFilm(int id, Film film, AuthorizedUser user) {
        // Check the arguments.
        if (film == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Delete an existing film.
     *
     * @param film The film that will be deleted.
     * @param user
     * @return The deleted film.
     */
    public Film deleteFilm(Film film, AuthorizedUser user) {
        // Check the arguments.
        if (film == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param film
     * @param user
     * @return an array with all the available films.
     */
    public List<Film> readFilm(Film film, AuthorizedUser user) {
        // Check the arguments.
        if (film == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
