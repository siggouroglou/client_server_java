package gr.papei.mainpackage.server.lib.authority;

/**
 * Authorization Exception class.
 * <br/>
 * Thrown when a user is trying to run a method without the required authority.
 * <br/>
 * Not available for extending more.
 * @author siggouroglou@gmail.com
 */
public final class AuthorizationException extends RuntimeException {

    public AuthorizationException() {
        super();
    }

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
