package gr.unipi.mainpackage.client.model.client;

/**
 * This is the model that server is receiving from client.
 * @author siggouroglou@gmail.com
 */
public class RequestModel {

    private Integer sessionId;
    private String entityName;
    private RequestMethod method;
    private String model;

    public RequestModel() {
        this.sessionId = -1;
        this.entityName = "";
        this.method = null;
        this.model = "";
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
