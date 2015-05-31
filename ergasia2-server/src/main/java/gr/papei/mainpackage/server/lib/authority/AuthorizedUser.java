package gr.papei.mainpackage.server.lib.authority;

import java.util.List;

/**
 * This interface defines types that are users with authorities.
 * @author siggouroglou
 */
public interface AuthorizedUser {

    public List<Authority> getAuthorities();
}
