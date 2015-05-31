package gr.unipi.mainpackage.server.lib.session;

import gr.unipi.mainpackage.server.lib.PropertiesUtilities;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class that manages the sessions of the users of the server.
 *
 * @author siggouroglou@gmail.com
 */
public final class SessionCache {

    private static SessionCache INSTANCE;
    private final Map<Integer, AuthorizationModel> sessionMap;

    private SessionCache() {
        this.sessionMap = new HashMap<>();
    }

    public static SessionCache getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SessionCache();
        }
        return INSTANCE;
    }
    
    public AuthorizationModel findBySessionId(Integer sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isExpired(Integer sessionId) {
        AuthorizationModel model = sessionMap.get(sessionId);
        
        // Check if has passed more than expireMinutes time.
        Date now = new Date();
        Date lastAccess = model.getLastAccess();
        if((now.getTime() - lastAccess.getTime()) > PropertiesUtilities.getInstance().getInt("session.expireMinutes")) {
            // Session expired.
            sessionMap.remove(sessionId);
            return true;
        } else {
            // Session not expired. Update the last access date.
            model.setLastAccess(now);
            return false;
        }
    }

}
