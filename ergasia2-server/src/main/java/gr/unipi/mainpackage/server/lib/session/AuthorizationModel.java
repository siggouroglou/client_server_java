package gr.unipi.mainpackage.server.lib.session;

import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import java.util.Date;

/**
 * This is a Java bean that wraps a user with a lastAccess date.
 * <br/>
 * Used only for the session map.
 * @author siggouroglou@gmail.com
 */
public class AuthorizationModel {

    private AuthorizedUser authorizedUser;
    private Date lastAccess;

    public AuthorizationModel() {
        this.authorizedUser = null;
        this.lastAccess = new Date();
    }

    public AuthorizedUser getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(AuthorizedUser authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }
}
