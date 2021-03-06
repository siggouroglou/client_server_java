package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.data.CinemaRoom;
import gr.unipi.mainpackage.server.service.fileManager.CinemaRoomDbFileManager;
import java.util.List;

/**
 * Database methods for model CinemaRoom.
 * <br/>
 * Every method name follows a standard convention that is used for Java Reflections calls from request manager.
 * @author siggouroglou@gmail.com
 */
public class CinemaRoomService {
    CinemaRoomDbFileManager dbManager;

    public CinemaRoomService() {
        dbManager = new CinemaRoomDbFileManager();
    }

    /**
     * Create a new cinema room.
     *
     * @param cinemaRoom The new cinema room that will be created.
     * @param user
     * @return the new cinema room object.
     */
    public CinemaRoom createCinemaRoom(CinemaRoom cinemaRoom, AuthorizedUser user) {
        // Check the arguments.
        if (cinemaRoom == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.CinemaRoom_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        CinemaRoom cinemaRoomNew = dbManager.create(cinemaRoom);
        
        return cinemaRoomNew;
    }

    /**
     * Update an existing cinema room.
     *
     * @param id The id of the cinema room that will be updated.
     * @param cinemaRoom The new cinema room that will replace the existing.
     * @param user
     * @return the new updated cinema room object.
     */
    public CinemaRoom updateCinemaRoom(int id, CinemaRoom cinemaRoom, AuthorizedUser user) {
        // Check the arguments.
        if (cinemaRoom == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.CinemaRoom_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Delete an existing cinema room.
     *
     * @param cinemaRoom The cinema room that will be deleted.
     * @param user
     * @return The deleted cinema room.
     */
    public CinemaRoom deleteCinemaRoom(CinemaRoom cinemaRoom, AuthorizedUser user) {
        // Check the arguments.
        if (cinemaRoom == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.CinemaRoom_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param cinemaRoom
     * @param user
     * @return an array with all the existing cinema rooms.
     */
    public List<CinemaRoom> readCinemaRoom(CinemaRoom cinemaRoom, AuthorizedUser user) {
        // Check the arguments.
        if (cinemaRoom == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.CinemaRoom_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
