package gr.unipi.mainpackage.server.lib.authority;

import java.util.List;

/**
 * This interface defines types that are users with authorities.
 * <br/>
 * It is not a strategy pattern.
 * @author siggouroglou
 */
public interface AuthorizedUser {

    public List<Authority> getAuthorities();
}
