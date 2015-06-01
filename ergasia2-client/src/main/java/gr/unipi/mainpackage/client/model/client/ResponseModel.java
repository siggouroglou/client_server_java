package gr.unipi.mainpackage.client.model.client;

/**
 * This is the model that clients are receiving as a response from the server.
 * @author siggouroglou@gmail.com
 */
public class ResponseModel {
    private String response;
    private int sessionId;

    public ResponseModel() {
        this.response = "";
        this.sessionId = -1;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}
