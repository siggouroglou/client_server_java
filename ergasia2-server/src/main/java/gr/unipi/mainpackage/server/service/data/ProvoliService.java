package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.data.Provoli;
import gr.unipi.mainpackage.server.service.fileManager.ProvoliDbFileManager;
import java.util.List;

/**
 *
 * Database methods for model Provoli.
 * <br/>
 * Every method name follows a standard convention that is used for Java Reflections calls from request manager.
 * @author siggouroglou@gmail.com
 */
public class ProvoliService {
    ProvoliDbFileManager dbManager;

    public ProvoliService() {
        dbManager = new ProvoliDbFileManager();
    }

    /**
     * Search for a provoli.
     *
     * @param provoli The provoli to be searched for.
     * @param user
     * @return the new provoli object.
     */
    public List<Provoli> searchProvoli(Provoli provoli, AuthorizedUser user) {
        // Check the arguments.
        if (provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_S, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        List<Provoli> provoliFoundList = dbManager.search(provoli);
        
        return provoliFoundList;
    }
    
    /**
     * Create a provoli object.
     * @param provoli The provoli object to be created.
     * @param user
     * @return the new provoli object.
     */
    public Provoli createProvoli(Provoli provoli, AuthorizedUser user) {
        // Check the arguments.
        if (provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        Provoli provoliNew = dbManager.create(provoli);
        
        return provoliNew;
    }
    
    /**
     * Update an existing provoli object.
     * @param id The id of the object provoli to be updated.
     * @param provoli The provoli object that will replace the existing.
     * @param user
     * @return The new updated provoli object.
     */
    public Provoli updateProvoli(int id, Provoli provoli, AuthorizedUser user) {
        // Check the arguments.
        if (provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Delete a provoli object.
     * @param provoli The provoli object that will be deleted.
     * @param user
     * @return the deleted provoli object.
     */
    public Provoli deleteProvoli(Provoli provoli, AuthorizedUser user) {
        // Check the arguments.
        if (provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * 
     * @param provoli
     * @param user
     * @return an array of provoli objects.
     */
    public List<Provoli> readProvoli(Provoli provoli, AuthorizedUser user) {
        // Check the arguments.
        if (provoli == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Provoli_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }

        // Implement the code.
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
