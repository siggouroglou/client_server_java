package gr.unipi.mainpackage.client.model.client;

/**
 * This is a response model that clients are receiving on error.
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
