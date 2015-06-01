package gr.unipi.mainpackage.server.service.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.server.model.data.Reservation;
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
public class ReservationDbFileManager implements DbFileManager<Reservation> {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ReservationDbFileManager.class);
    private static final String DB_PATH = "database/Reservation.db";

    @Override
    public List<Reservation> search(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservation create(Reservation reservation) {
        // Get all the admins from file.
        List<Reservation> dbList = readOrWriteToFile(null);

        // Add the new one.
        dbList.add(reservation);

        // Get the distinct admin List.
        List<Reservation> distinctList = dbList.stream().distinct().collect(Collectors.toList());

        // Save them back to file.
        readOrWriteToFile(distinctList);

        return reservation;
    }

    @Override
    public List<Reservation> readAll(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservation read(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservation update(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservation delete(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private synchronized List<Reservation> readOrWriteToFile(List<Reservation> writeList) {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();

        // Case when reading.
        if (writeList == null) {
            try {
                String readJson = new String(Files.readAllBytes(Paths.get(DB_PATH)), "utf-8");
                Reservation[] array = gson.fromJson(readJson, Reservation[].class);
                if (array == null) {
                    return new ArrayList<>();
                } else {
                    return new ArrayList<>(Arrays.asList(array));
                }
            } catch (Exception ex) {
                logger.error("DB Reservation file didn't read.", ex);
            }
        }

        // Case when writing.
        if (writeList != null) {
            try {
                Files.write(Paths.get(DB_PATH), gson.toJson(writeList.toArray(), Reservation[].class).getBytes("utf-8"));
            } catch (IOException ex) {
                logger.error("DB Reservation file didn't writen.", ex);
            }
        }

        return null;
    }

}
