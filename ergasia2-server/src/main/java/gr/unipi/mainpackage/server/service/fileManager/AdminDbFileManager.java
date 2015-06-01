package gr.unipi.mainpackage.server.service.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.server.model.data.Admin;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implement the database insert/update/delete and select methods.
 * <br/>
 * It is working as a front end with the file database as backend.
 * <br/>
 * Every data is saved with json format.
 *
 * @author siggouroglou@gmail.com
 */
public class AdminDbFileManager implements DbFileManager<Admin> {

    @Override
    public List<Admin> search(Admin admin) {
        // Get all the admins from file.
        List<Admin> dbList = readOrWriteToFile(null);
        List<Admin> returnList = new LinkedList<>();

        // Search for object that are simmilar with the argument.
        for (Admin curent : dbList) {
            if ((admin.getName().isEmpty() || (!admin.getName().isEmpty() && admin.getName().equals(curent.getName())))
                    && (admin.getUsername().isEmpty() || (!admin.getUsername().isEmpty() && admin.getUsername().equals(curent.getUsername())))
                    && (admin.getPassword().isEmpty() || (!admin.getPassword().isEmpty() && admin.getPassword().equals(curent.getPassword())))) {
                returnList.add(curent);
            }
        }

        return returnList;
    }

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AdminDbFileManager.class);
    private static final String DB_PATH = "database/Admin.db";

    @Override
    public Admin create(Admin admin) {
        // Get all the admins from file.
        List<Admin> dbList = readOrWriteToFile(null);

        // Add the new one.
        dbList.add(admin);

        // Get the distinct admin List.
        List<Admin> distinctList = dbList.stream().distinct().collect(Collectors.toList());

        // Save them back to file.
        readOrWriteToFile(distinctList);

        return admin;
    }

    @Override
    public List<Admin> readAll(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin read(Admin admin) {
        // Get all the admins from file.
        List<Admin> dbList = readOrWriteToFile(null);

        // Search for the first occurance of the admin with the above.
        Admin adminFound = null;
        for (Admin curent : dbList) {
            if (curent.equals(admin)) {
                adminFound = curent;
                break;
            }
        }

        return adminFound;
    }

    @Override
    public Admin update(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin delete(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private synchronized List<Admin> readOrWriteToFile(List<Admin> writeList) {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();

        // Case when reading.
        if (writeList == null) {
            try {
                String readJson = new String(Files.readAllBytes(Paths.get(DB_PATH)), "utf-8");
                Admin[] array = gson.fromJson(readJson, Admin[].class);
                if (array == null) {
                    return new ArrayList<>();
                } else {
                    return new ArrayList<>(Arrays.asList(array));
                }
            } catch (Exception ex) {
                logger.error("DB Admin file didn't read.", ex);
            }
        }

        // Case when writing.
        if (writeList != null) {
            try {
                Files.write(Paths.get(DB_PATH), gson.toJson(writeList.toArray(), Admin[].class).getBytes("utf-8"));
            } catch (IOException ex) {
                logger.error("DB Admin file didn't writen.", ex);
            }
        }

        return null;
    }

}
