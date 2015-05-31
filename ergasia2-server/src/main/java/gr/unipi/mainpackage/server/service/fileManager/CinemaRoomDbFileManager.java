package gr.unipi.mainpackage.server.service.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.server.model.data.CinemaRoom;
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
public class CinemaRoomDbFileManager implements DbFileManager<CinemaRoom> {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CinemaRoomDbFileManager.class);
    private static final String DB_PATH = "database/CinemaRoom.db";

    @Override
    public CinemaRoom create(CinemaRoom cinemaRoom) {
        // Get all the admins from file.
        List<CinemaRoom> dbList = readOrWriteToFile(null);

        // Add the new one.
        dbList.add(cinemaRoom);

        // Get the distinct admin List.
        List<CinemaRoom> distinctList = dbList.stream().distinct().collect(Collectors.toList());

        // Save them back to file.
        readOrWriteToFile(distinctList);

        return cinemaRoom;
    }

    @Override
    public List<CinemaRoom> readAll(CinemaRoom t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CinemaRoom read(CinemaRoom t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CinemaRoom update(CinemaRoom t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CinemaRoom delete(CinemaRoom t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private synchronized List<CinemaRoom> readOrWriteToFile(List<CinemaRoom> writeList ){
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();

        // Case when reading.
        if (writeList == null) {
            try {
                String readJson = new String(Files.readAllBytes(Paths.get(DB_PATH)), "utf-8");
                CinemaRoom[] array = gson.fromJson(readJson, CinemaRoom[].class);
                if (array == null) {
                    return new ArrayList<>();
                } else {
                    return Arrays.asList(array);
                }
            } catch (Exception ex) {
                logger.error("DB CinemaRoom file didn't read.", ex);
            }
        }

        // Case when writing.
        if (writeList != null) {
            try {
                Files.write(Paths.get(DB_PATH), gson.toJson(writeList.toArray(), CinemaRoom[].class).getBytes("utf-8"));
            } catch (IOException ex) {
                logger.error("DB CinemaRoom file didn't writen.", ex);
            }
        }

        return null;
    }

}
