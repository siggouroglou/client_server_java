package gr.unipi.mainpackage.server.service.fileManager;

import gr.unipi.mainpackage.server.model.Film;
import java.util.List;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class FilmDbFileManager implements DbFileManager<Film> {

    @Override
    public synchronized Film create(Film t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public synchronized Film update(Film t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized Film delete(Film t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
