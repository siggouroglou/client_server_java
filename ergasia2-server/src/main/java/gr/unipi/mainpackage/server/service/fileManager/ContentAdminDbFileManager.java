package gr.unipi.mainpackage.server.service.fileManager;

import gr.unipi.mainpackage.server.model.data.ContentAdmin;
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
public class ContentAdminDbFileManager implements DbFileManager<ContentAdmin> {

    @Override
    public synchronized ContentAdmin create(ContentAdmin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public synchronized ContentAdmin update(ContentAdmin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized ContentAdmin delete(ContentAdmin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
