package gr.unipi.mainpackage.server.lib.session;

import gr.unipi.mainpackage.server.lib.PropertiesUtilities;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
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
    private int sequenceNo;

    private SessionCache() {
        this.sessionMap = new HashMap<>();
        this.sequenceNo = 1;
        
//        // Code to help me login an admin for creating him.
//        Admin admin = new Admin();
//        admin.setPassword(Encryption.getHashMD5("qweqwe"));
//        
//        AuthorizationModel authorizationModel = new AuthorizationModel();
//        authorizationModel.setLastAccess(new Date());
//        authorizationModel.setAuthorizedUser(admin);
//        sessionMap.put(1, authorizationModel);
    }

    public static SessionCache getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SessionCache();
        }
        return INSTANCE;
    }
    
    private synchronized int getNextVal() {
        return ++sequenceNo;
    }
    
    public AuthorizationModel findBySessionId(Integer sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isExpired(Integer sessionId) {
        AuthorizationModel model = sessionMap.get(sessionId);
        
        // Check if has passed more than expireMilis time.
        Date now = new Date();
        Date lastAccess = model.getLastAccess();
        if((now.getTime() - lastAccess.getTime()) > PropertiesUtilities.getInstance().getInt("session.expireMilis")) {
            // Session expired.
            sessionMap.remove(sessionId);
            return true;
        } else {
            // Session not expired. Update the last access date.
            model.setLastAccess(now);
            return false;
        }
    }

    public int loginUser(AuthorizedUser authorizedUser) {
        AuthorizationModel authorizationModel = new AuthorizationModel();
        authorizationModel.setAuthorizedUser(authorizedUser);
        authorizationModel.setLastAccess(new Date());
        
        int sequenceGiven = getNextVal();
        sessionMap.put(sequenceGiven, authorizationModel);
        
        return sequenceGiven;
    }

}
