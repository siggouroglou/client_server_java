package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.signin.SignInAbleService;
import gr.unipi.mainpackage.server.lib.signin.SignInAbleUser;
import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.data.ContentAdmin;
import gr.unipi.mainpackage.server.service.fileManager.ContentAdminDbFileManager;
import java.util.List;

/**
 *
 * Database methods for model ContentAdmin.
 * <br/>
 * Every method name follows a standard convention that is used for Java
 * Reflections calls from request manager.
 *
 * @author siggouroglou@gmail.com
 */
public class ContentAdminService implements SignInAbleService {

    ContentAdminDbFileManager dbManager;

    public ContentAdminService() {
        dbManager = new ContentAdminDbFileManager();
    }

    /**
     *
     * @param contentAdmin The object that includes the criteria that will be
     * used for searching. Criteria is every column is not having null value.
     * @param user
     * @return
     */
    public List<ContentAdmin> searchContentAdmin(ContentAdmin contentAdmin, AuthorizedUser user) {
        // Check the arguments.
        if (contentAdmin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.ContentAdmin_S, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
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
        ContentAdmin contentAdminNew = dbManager.create(contentAdmin);

        return contentAdminNew;
    }

    /**
     * Update an existing contentAdmin.
     *
     * @param id The id of the existing contentAdmin that will be updated.
     * @param contentAdmin The contentAdmin that will replace the existing
     * contentAdmin.
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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param contentAdmin
     * @param user
     * @return an array with all the existing contentAdmins.
     */
    public List<ContentAdmin> readContentAdmin(ContentAdmin contentAdmin, AuthorizedUser user) {
        // Check the arguments.
        if (contentAdmin == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.ContentAdmin_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AuthorizedUser login(SignInAbleUser user) {
        // Get the user with this username, password.
        List<ContentAdmin> contentAdminList = dbManager.search((ContentAdmin) user);

        // Return true if it is found.
        return contentAdminList.size() == 1 ? contentAdminList.get(0) : null;
    }

    @Override
    public AuthorizedUser logout(SignInAbleUser user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
