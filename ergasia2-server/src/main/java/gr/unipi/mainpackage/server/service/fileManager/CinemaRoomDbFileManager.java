package gr.unipi.mainpackage.server.service.fileManager;

import gr.unipi.mainpackage.server.model.data.CinemaRoom;
import java.util.List;

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

    @Override
    public synchronized CinemaRoom create(CinemaRoom t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public synchronized CinemaRoom update(CinemaRoom t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized CinemaRoom delete(CinemaRoom t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
