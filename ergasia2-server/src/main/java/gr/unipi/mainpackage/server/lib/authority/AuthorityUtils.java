package gr.unipi.mainpackage.server.lib.authority;

/**
 * Utility class that include only one method.
 * @author siggouroglou@gmail.com
 */
public class AuthorityUtils {

    /**
     * Method that is checking if the corresponding user has the given authority.
     * @param authority The authority to check.
     * @param authorizedUser The user to check if includes the given authority.
     * @return true if the given user includes the given authority.
     */
    public static boolean hasAuthority(Authority authority, AuthorizedUser authorizedUser) {
        // Check the arguments.
        if (authority == null || authorizedUser == null) {
            return false;
        }
        
        // Flas to intigate if this user is authorized.
        boolean hasAuthority = false;
        
        // Itereate through user athorities.
        for(Authority userAuthority : authorizedUser.getAuthorities()){
            if(userAuthority.equals(authority)) {
                hasAuthority = true;
                break;
            }
        }
        
        return hasAuthority;
    }
}
