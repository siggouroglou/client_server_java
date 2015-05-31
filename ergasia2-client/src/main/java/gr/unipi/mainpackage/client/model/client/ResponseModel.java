package gr.unipi.mainpackage.client.model.client;

/**
 * This is the model that clients are receiving as a response from the server.
 * @author siggouroglou@gmail.com
 */
public class ResponseModel {
    private String response;

    public ResponseModel() {
        this.response = "";
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
