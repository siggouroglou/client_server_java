package gr.papei.mainpackage.server.service;

import gr.papei.mainpackage.server.lib.authority.Authority;
import gr.papei.mainpackage.server.lib.authority.AuthorityUtils;
import gr.papei.mainpackage.server.lib.authority.AuthorizationException;
import gr.papei.mainpackage.server.lib.authority.AuthorizedUser;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class FilmService {

    public FilmService() {
    }

    /**
     * Creates a new film.
     *
     * @param film The film to be created.
     * @param user
     * @return the new film object.
     */
    public FilmService createFilm(FilmService film, AuthorizedUser user) {
        // Check the arguments.
        if (film == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Film created");
        return null;
    }

    /**
     * Updates an existing film.
     *
     * @param id The id of the film to be updated.
     * @param film The new file that will update the existing.
     * @param user
     * @return the new updated film.
     */
    public FilmService updateFilm(int id, FilmService film, AuthorizedUser user) {
        // Check the arguments.
        if (film == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Film update");
        return null;
    }

    /**
     * Delete an existing film.
     *
     * @param film The film that will be deleted.
     * @param user
     * @return The deleted film.
     */
    public FilmService deleteFilm(FilmService film, AuthorizedUser user) {
        // Check the arguments.
        if (film == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Film delete");
        return null;
    }

    /**
     *
     * @param user
     * @return an array with all the available films.
     */
    public FilmService[] readAllFilms(AuthorizedUser user) {
        // Check the arguments.
        if (user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Film_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Read all the Films");
        return null;
    }

}
