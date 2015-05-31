package gr.unipi.mainpackage.server.lib.signin;

/**
 *
 * This interface is an implentation of a service that serves the login and logout methods.
 * @author siggouroglou
 */
public interface SignInAbleService {
    
    public boolean login(SignInAbleUser user);
    public boolean logout(SignInAbleUser user);
}
