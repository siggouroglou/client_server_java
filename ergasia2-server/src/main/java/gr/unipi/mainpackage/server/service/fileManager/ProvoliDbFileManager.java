package gr.unipi.mainpackage.server.service.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.server.model.data.Provoli;
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
 * @author siggouroglou@gmail.com
 */
public class ProvoliDbFileManager implements DbFileManager<Provoli> {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProvoliDbFileManager.class);
    private static final String DB_PATH = "database/Provoli.db";

    @Override
    public List<Provoli> search(Provoli provoli) {
        // Get all the provolis from file.
        List<Provoli> dbList = readOrWriteToFile(null);
        List<Provoli> returnList = new LinkedList<>();

        // Search for object that are simmilar with the argument.
        for (Provoli curent : dbList) {
            if ((provoli.getId() <= 0 || (provoli.getId() > 0 && provoli.getId() == curent.getId()))
                    && (provoli.getFilmId() <= 0 || (provoli.getFilmId() > 0 && provoli.getFilmId() == curent.getFilmId()))
                    && (provoli.getCinemaRoomId() <= 0 || (provoli.getCinemaRoomId() > 0 && provoli.getCinemaRoomId() == curent.getCinemaRoomId()))
                    && (provoli.getStartDate() == null || (provoli.getStartDate() != null && provoli.getStartDate().equals(curent.getStartDate())))
                    && (provoli.getEndDate() == null || (provoli.getEndDate() != null && provoli.getEndDate().equals(curent.getEndDate())))
                    && (provoli.getNumberOfReservations() <= 0 || (provoli.getNumberOfReservations() > 0 && provoli.getNumberOfReservations() == curent.getNumberOfReservations()))
                    && (provoli.isAvailable() == curent.isAvailable())) {
                returnList.add(curent);
            }
        }

        return returnList;
    }

    @Override
    public Provoli create(Provoli provoli) {
        // Get all the provolis from file.
        List<Provoli> dbList = readOrWriteToFile(null);

        // Add the new one.
        dbList.add(provoli);

        // Get the distinct provoli List.
        List<Provoli> distinctList = dbList.stream().distinct().collect(Collectors.toList());

        // Save them back to file.
        readOrWriteToFile(distinctList);

        return provoli;
    }

    @Override
    public List<Provoli> readAll(Provoli t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Provoli read(Provoli t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Provoli update(Provoli t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Provoli delete(Provoli t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private synchronized List<Provoli> readOrWriteToFile(List<Provoli> writeList) {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();

        // Case when reading.
        if (writeList == null) {
            try {
                String readJson = new String(Files.readAllBytes(Paths.get(DB_PATH)), "utf-8");
                Provoli[] array = gson.fromJson(readJson, Provoli[].class);
                if (array == null) {
                    return new ArrayList<>();
                } else {
                    return new ArrayList<>(Arrays.asList(array));
                }
            } catch (Exception ex) {
                logger.error("DB Provoli file didn't read.", ex);
            }
        }

        // Case when writing.
        if (writeList != null) {
            try {
                Files.write(Paths.get(DB_PATH), gson.toJson(writeList.toArray(), Provoli[].class).getBytes("utf-8"));
            } catch (IOException ex) {
                logger.error("DB Provoli file didn't writen.", ex);
            }
        }

        return null;
    }

}
