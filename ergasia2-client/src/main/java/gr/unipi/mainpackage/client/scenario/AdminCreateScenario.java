package gr.unipi.mainpackage.client.scenario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.client.model.client.RequestMethod;
import gr.unipi.mainpackage.client.model.client.RequestModel;
import gr.unipi.mainpackage.client.model.data.Admin;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class AdminCreateScenario implements Scenario {

    private RequestModel requestModel;

    public AdminCreateScenario(Admin admin, int sessionId) {
        // Gson for converting this admin to json.
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();
        
        // Initialize the requestModel
        requestModel = new RequestModel();
        requestModel.setEntityName("Admin");
        requestModel.setMethod(RequestMethod.CREATE);
        requestModel.setModel(gson.toJson(admin, Admin.class));
        requestModel.setSessionId(sessionId);
    }

    @Override
    public RequestModel getRequest() {
        return this.requestModel;
    }
}
