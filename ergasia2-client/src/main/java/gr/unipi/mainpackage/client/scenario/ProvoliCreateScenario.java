package gr.unipi.mainpackage.client.scenario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.client.model.client.RequestMethod;
import gr.unipi.mainpackage.client.model.client.RequestModel;
import gr.unipi.mainpackage.client.model.data.Provoli;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ProvoliCreateScenario implements Scenario {

    private RequestModel requestModel;

    public ProvoliCreateScenario(Provoli provoli) {
        // Gson for converting this admin to json.
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();
        
        // Initialize the requestModel
        requestModel = new RequestModel();
        requestModel.setEntityName("Provoli");
        requestModel.setMethod(RequestMethod.CREATE);
        requestModel.setModel(gson.toJson(provoli, Provoli.class));
    }

    @Override
    public RequestModel getRequest() {
        return this.requestModel;
    }
}
