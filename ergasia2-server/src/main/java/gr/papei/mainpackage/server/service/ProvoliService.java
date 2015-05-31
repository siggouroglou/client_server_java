package gr.papei.mainpackage.server.service;

import gr.papei.mainpackage.server.lib.authority.Authority;
import gr.papei.mainpackage.server.lib.authority.AuthorityUtils;
import gr.papei.mainpackage.server.lib.authority.AuthorizationException;
import gr.papei.mainpackage.server.lib.authority.AuthorizedUser;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ProvoliService {

    public ProvoliService() {
    }
    
    /**
     * Create a provoli object.
     * @param provoli The provoli object to be created.
     * @param user
     * @return the new provoli object.
     */
    public ProvoliService createProvoli(ProvoliService provoli, AuthorizedUser user) {
        // Check the arguments.
        if (provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Provoli created");
        return null;
    }
    
    /**
     * Update an existing provoli object.
     * @param id The id of the object provoli to be updated.
     * @param provoli The provoli object that will replace the existing.
     * @param user
     * @return The new updated provoli object.
     */
    public ProvoliService updateProvoli(int id, ProvoliService provoli, AuthorizedUser user) {
        // Check the arguments.
        if (provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Provoli updated");
        return null;
    }
    
    /**
     * Delete a provoli object.
     * @param provoli The provoli object that will be deleted.
     * @param user
     * @return the deleted provoli object.
     */
    public ProvoliService deleteProvoli(ProvoliService provoli, AuthorizedUser user) {
        // Check the arguments.
        if (provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("Provoli deleted");
        return null;
    }
    
    /**
     * 
     * @param user
     * @return an array of provoli objects.
     */
    public ProvoliService[] readAllProvoli(AuthorizedUser user) {
        // Check the arguments.
        if (user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        System.out.println("read all the Provoli");
        return null;
    }
}
