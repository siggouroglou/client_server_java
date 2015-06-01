package gr.unipi.mainpackage.client.scenario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.client.model.client.RequestMethod;
import gr.unipi.mainpackage.client.model.client.RequestModel;
import gr.unipi.mainpackage.client.model.data.ContentAdmin;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ContentAdminLoginScenario implements Scenario {

    private RequestModel requestModel;

    public ContentAdminLoginScenario(ContentAdmin contentAdmin) {
        // Gson for converting this admin to json.
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();
        
        // Initialize the requestModel
        requestModel = new RequestModel();
        requestModel.setEntityName("ContentAdmin");
        requestModel.setMethod(RequestMethod.LOGIN);
        requestModel.setModel(gson.toJson(contentAdmin, ContentAdmin.class));
    }

    @Override
    public RequestModel getRequest() {
        return this.requestModel;
    }
}
