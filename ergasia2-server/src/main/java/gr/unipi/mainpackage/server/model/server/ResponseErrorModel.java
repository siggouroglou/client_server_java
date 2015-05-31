package gr.unipi.mainpackage.server.model.server;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ResponseErrorModel {

    private String errorMessage;

    public ResponseErrorModel() {
        this.errorMessage = "";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
