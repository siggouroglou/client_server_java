package gr.unipi.mainpackage.client.scenario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.client.model.client.RequestMethod;
import gr.unipi.mainpackage.client.model.client.RequestModel;
import gr.unipi.mainpackage.client.model.data.Customer;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class CustomerCreateScenario implements Scenario {

    private RequestModel requestModel;

    public CustomerCreateScenario(Customer customer) {
        // Gson for converting this admin to json.
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();
        
        // Initialize the requestModel
        requestModel = new RequestModel();
        requestModel.setEntityName("Customer");
        requestModel.setMethod(RequestMethod.CREATE);
        requestModel.setModel(gson.toJson(customer, Customer.class));
    }

    @Override
    public RequestModel getRequest() {
        return this.requestModel;
    }
}
