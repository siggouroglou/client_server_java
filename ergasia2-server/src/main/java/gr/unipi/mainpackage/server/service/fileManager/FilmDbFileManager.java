package gr.unipi.mainpackage.server.service.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.unipi.mainpackage.server.model.data.Film;
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
public class FilmDbFileManager implements DbFileManager<Film> {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FilmDbFileManager.class);
    private static final String DB_PATH = "database/Film.db";

    @Override
    public Film create(Film film) {
        // Get all the admins from file.
        List<Film> dbList = readOrWriteToFile(null);

        // Add the new one.
        dbList.add(film);

        // Get the distinct admin List.
        List<Film> distinctList = dbList.stream().distinct().collect(Collectors.toList());

        // Save them back to file.
        readOrWriteToFile(distinctList);

        return film;
    }

    @Override
    public List<Film> readAll(Film t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Film read(Film t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Film update(Film t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Film delete(Film t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private synchronized List<Film> readOrWriteToFile(List<Film> writeList) {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();

        // Case when reading.
        if (writeList == null) {
            try {
                String readJson = new String(Files.readAllBytes(Paths.get(DB_PATH)), "utf-8");
                Film[] array = gson.fromJson(readJson, Film[].class);
                if (array == null) {
                    return new ArrayList<>();
                } else {
                    return Arrays.asList(array);
                }
            } catch (Exception ex) {
                logger.error("DB Film file didn't read.", ex);
            }
        }

        // Case when writing.
        if (writeList != null) {
            try {
                Files.write(Paths.get(DB_PATH), gson.toJson(writeList.toArray(), Film[].class).getBytes("utf-8"));
            } catch (IOException ex) {
                logger.error("DB Film file didn't writen.", ex);
            }
        }

        return null;
    }

}
