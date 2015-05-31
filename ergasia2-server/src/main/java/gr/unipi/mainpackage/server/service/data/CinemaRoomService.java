package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class CinemaRoomService {

    public CinemaRoomService() {
    }

    /**
     * Create a new cinema room.
     *
     * @param cinemaRoom The new cinema room that will be created.
     * @param user
     * @return the new cinema room object.
     */
    public CinemaRoomService createCinemaRoom(CinemaRoomService cinemaRoom, AuthorizedUser user) {
        // Check the arguments.
        if (cinemaRoom == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.CinemaRoom_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("CinemaRoom created");
        return null;
    }

    /**
     * Update an existing cinema room.
     *
     * @param id The id of the cinema room that will be updated.
     * @param cinemaRoom The new cinema room that will replace the existing.
     * @param user
     * @return the new updated cinema room object.
     */
    public CinemaRoomService updateCinemaRoom(int id, CinemaRoomService cinemaRoom, AuthorizedUser user) {
        // Check the arguments.
        if (cinemaRoom == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.CinemaRoom_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("CinemaRoom update");
        return null;
    }

    /**
     * Delete an existing cinema room.
     *
     * @param cinemaRoom The cinema room that will be deleted.
     * @param user
     * @return The deleted cinema room.
     */
    public CinemaRoomService deleteCinemaRoom(CinemaRoomService cinemaRoom, AuthorizedUser user) {
        // Check the arguments.
        if (cinemaRoom == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.CinemaRoom_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("CinemaRoom delete");
        return null;
    }

    /**
     *
     * @param user
     * @return an array with all the existing cinema rooms.
     */
    public CinemaRoomService[] readAllCinemaRooms(AuthorizedUser user) {
        // Check the arguments.
        if (user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.CinemaRoom_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("Read all the CinemaRooms");
        return null;
    }
}
