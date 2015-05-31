package gr.unipi.mainpackage.server.model.server;

/**
 *
 * @author siggouroglou
 */
public enum RequestMethod {
    SEARCH, CREATE, READ, UPDATE, DELETE, LOGIN, LOGOUT;

    @Override
    public String toString() {
        switch (this) {
            case SEARCH:
                return "search";
            case CREATE:
                return "create";
            case READ:
                return "read";
            case UPDATE:
                return "update";
            case DELETE:
                return "delete";
            case LOGIN:
                return "login";
            case LOGOUT:
                return "logout";
        }
        throw new IllegalArgumentException("RequestMethod state is not valid.");
    }
}
