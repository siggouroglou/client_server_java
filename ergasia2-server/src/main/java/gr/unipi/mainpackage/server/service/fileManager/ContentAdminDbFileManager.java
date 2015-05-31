package gr.unipi.mainpackage.server.service.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.server.model.data.ContentAdmin;
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
 *
 * @author siggouroglou@gmail.com
 */
public class ContentAdminDbFileManager implements DbFileManager<ContentAdmin> {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ContentAdminDbFileManager.class);
    private static final String DB_PATH = "database/ContentAdmin.db";

    @Override
    public ContentAdmin create(ContentAdmin contentAdmin) {
        // Get all the admins from file.
        List<ContentAdmin> dbList = readOrWriteToFile(null);

        // Add the new one.
        dbList.add(contentAdmin);

        // Get the distinct admin List.
        List<ContentAdmin> distinctList = dbList.stream().distinct().collect(Collectors.toList());

        // Save them back to file.
        readOrWriteToFile(distinctList);

        return contentAdmin;
    }

    @Override
    public List<ContentAdmin> readAll(ContentAdmin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContentAdmin read(ContentAdmin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContentAdmin update(ContentAdmin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContentAdmin delete(ContentAdmin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private synchronized List<ContentAdmin> readOrWriteToFile(List<ContentAdmin> writeList) {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();

        // Case when reading.
        if (writeList == null) {
            try {
                String readJson = new String(Files.readAllBytes(Paths.get(DB_PATH)), "utf-8");
                ContentAdmin[] array = gson.fromJson(readJson, ContentAdmin[].class);
                if (array == null) {
                    return new ArrayList<>();
                } else {
                    return Arrays.asList(array);
                }
            } catch (Exception ex) {
                logger.error("DB ContentAdmin file didn't read.", ex);
            }
        }

        // Case when writing.
        if (writeList != null) {
            try {
                Files.write(Paths.get(DB_PATH), gson.toJson(writeList.toArray(), ContentAdmin[].class).getBytes("utf-8"));
            } catch (IOException ex) {
                logger.error("DB ContentAdmin file didn't writen.", ex);
            }
        }

        return null;
    }

}
