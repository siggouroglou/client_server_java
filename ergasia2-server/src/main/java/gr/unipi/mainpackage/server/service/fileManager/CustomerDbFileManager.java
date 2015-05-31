package gr.unipi.mainpackage.server.service.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.server.model.data.Customer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * This class implement the database insert/update/delete and select methods.
 * <br/>
 * It is working as a front end with the file database as backend.
 * <br/>
 * Every data is saved with json format.
 * @author siggouroglou@gmail.com
 */
public class CustomerDbFileManager implements DbFileManager<Customer> {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CustomerDbFileManager.class);
    private static final String DB_PATH = "database/Customer.db";

    @Override
    public Customer create(Customer customer) {
        // Get all the admins from file.
        List<Customer> dbList = readOrWriteToFile(null);

        // Add the new one.
        dbList.add(customer);

        // Get the distinct admin List.
        List<Customer> distinctList = dbList.stream().distinct().collect(Collectors.toList());

        // Save them back to file.
        readOrWriteToFile(distinctList);

        return customer;
    }

    @Override
    public List<Customer> readAll(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer read(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer update(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer delete(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private synchronized List<Customer> readOrWriteToFile(List<Customer> writeList) {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();

        // Case when reading.
        if (writeList == null) {
            try {
                String readJson = new String(Files.readAllBytes(Paths.get(DB_PATH)), "utf-8");
                Customer[] array = gson.fromJson(readJson, Customer[].class);
                if (array == null) {
                    return new ArrayList<>();
                } else {
                    return Arrays.asList(array);
                }
            } catch (Exception ex) {
                logger.error("DB Customer file didn't read.", ex);
            }
        }

        // Case when writing.
        if (writeList != null) {
            try {
                Files.write(Paths.get(DB_PATH), gson.toJson(writeList.toArray(), Customer[].class).getBytes("utf-8"));
            } catch (IOException ex) {
                logger.error("DB Customer file didn't writen.", ex);
            }
        }

        return null;
    }

}
