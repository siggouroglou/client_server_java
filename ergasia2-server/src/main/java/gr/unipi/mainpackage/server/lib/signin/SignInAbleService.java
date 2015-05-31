package gr.unipi.mainpackage.server.lib.signin;

/**
 *
 * @author siggouroglou
 */
public interface SignInAbleService {
    
    public boolean login(SignInAbleUser user);
    public boolean logout(SignInAbleUser user);
}
