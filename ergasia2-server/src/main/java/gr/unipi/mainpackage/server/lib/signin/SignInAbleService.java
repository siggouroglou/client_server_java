package gr.unipi.mainpackage.server.lib.signin;

import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;

/**
 *
 * This interface is an implentation of a service that serves the login and logout methods.
 * @author siggouroglou
 */
public interface SignInAbleService {
    
    public AuthorizedUser login(SignInAbleUser user);
    public AuthorizedUser logout(SignInAbleUser user);
}
