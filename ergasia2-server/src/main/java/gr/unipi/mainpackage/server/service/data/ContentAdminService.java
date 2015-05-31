package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.SignInAble;
import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.ContentAdmin;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ContentAdminService implements SignInAble {

    public ContentAdminService() {
        super();
    }

    /**
     *
     * @param contentAdmin The object that includes the criteria that will be used for
     * searching. Criteria is every column is not having null value.
     * @param user
     * @return
     */
    public ContentAdmin[] searchContentAdmin(ContentAdmin contentAdmin, AuthorizedUser user) {
        // Check the arguments.
        if (contentAdmin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.ContentAdmin_S, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        return null;
    }

    /**
     * Create a new ContentAdmin object.
     *
     * @param contentAdmin The new contentAdmin that will be created.
     * @param user
     * @return the contentAdmin object that has been created.
     */
    public ContentAdmin createContentAdmin(ContentAdmin contentAdmin, AuthorizedUser user) {
        // Check the arguments.
        if (contentAdmin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.ContentAdmin_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("ContentAdmin created");
        return null;
    }

    /**
     * Update an existing contentAdmin.
     *
     * @param id The id of the existing contentAdmin that will be updated.
     * @param contentAdmin The contentAdmin that will replace the existing contentAdmin.
     * @param user
     * @return The new updated contentAdmin object.
     */
    public ContentAdmin updateContentAdmin(int id, ContentAdmin contentAdmin, AuthorizedUser user) {
        // Check the arguments.
        if (contentAdmin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.ContentAdmin_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("ContentAdmin updated");
        return null;
    }

    /**
     * Deletes a contentAdmin.
     *
     * @param contentAdmin The contentAdmin that will be deleted.
     * @param user
     * @return The contentAdmin that was deleted.
     */
    public ContentAdmin deleteContentAdmin(ContentAdmin contentAdmin, AuthorizedUser user) {
        // Check the arguments.
        if (contentAdmin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.ContentAdmin_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("ContentAdmin deleted");
        return null;
    }

    /**
     *
     * @param user
     * @return an array with all the existing contentAdmins.
     */
    public ContentAdmin[] readAllContentAdmins(AuthorizedUser user) {
        // Check the arguments.
        if (user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.ContentAdmin_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("Read all ContentAdmins");
        return null;
    }
    
    @Override
    public boolean login(){
        return true;
    }
    
    @Override
    public boolean logout(){
        return true;
    }

}
