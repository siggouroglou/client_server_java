package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.SignInAbleService;
import gr.unipi.mainpackage.server.lib.SignInAbleUser;
import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.Admin;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class AdminService implements SignInAbleService {

    public AdminService() {
    }

    /**
     *
     * @param admin The object that includes the criteria that will be used for
     * searching. Criteria is every column is not having null value.
     * @param user
     * @return
     */
    public Admin[] searchAdmin(Admin admin, AuthorizedUser user) {
        // Check the arguments.
        if (admin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Admin_S, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        return null;
    }

    /**
     * Create a new Admin object.
     *
     * @param admin The new admin that will be created.
     * @param user
     * @return the admin object that has been created.
     */
    public Admin createAdmin(Admin admin, AuthorizedUser user) {
        // Check the arguments.
        if (admin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Admin_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("Admin created");
        return null;
    }

    /**
     * Update an existing admin.
     *
     * @param id The id of the existing admin that will be updated.
     * @param admin The admin that will replace the existing admin.
     * @param user
     * @return The new updated admin object.
     */
    public Admin updateAdmin(int id, Admin admin, AuthorizedUser user) {
        // Check the arguments.
        if (admin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Admin_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("Admin updated");
        return null;
    }

    /**
     * Deletes a admin.
     *
     * @param admin The admin that will be deleted.
     * @param user
     * @return The admin that was deleted.
     */
    public Admin deleteAdmin(Admin admin, AuthorizedUser user) {
        // Check the arguments.
        if (admin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Admin_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("Admin deleted");
        return null;
    }

    /**
     *
     * @param admin
     * @param user
     * @return an array with all the existing admins.
     */
    public Admin[] readAdmin(Admin admin, AuthorizedUser user) {
        // Check the arguments.
        if (admin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Admin_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("Read all Admins");
        return null;
    }
    
    @Override
    public boolean login(SignInAbleUser user){
        return true;
    }
    
    @Override
    public boolean logout(SignInAbleUser user){
        return true;
    }

}
