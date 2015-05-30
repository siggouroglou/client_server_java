package gr.papei.mainpackage.server.service;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ProvoliService {

    public ProvoliService() {
    }
    
    /**
     * Create a provoli object.
     * @param provoli The provoli object to be created.
     * @return the new provoli object.
     */
    public ProvoliService createProvoli(ProvoliService provoli) {
        System.out.println("Provoli created");
        return null;
    }
    
    /**
     * Update an existing provoli object.
     * @param id The id of the object provoli to be updated.
     * @param provoli The provoli object that will replace the existing.
     * @return The new updated provoli object.
     */
    public ProvoliService updateProvoli(int id, ProvoliService provoli) {
        System.out.println("Provoli updated");
        return null;
    }
    
    /**
     * Delete a provoli object.
     * @param provoli The provoli object that will be deleted.
     * @return the deleted provoli object.
     */
    public ProvoliService deleteProvoli(ProvoliService provoli) {
        System.out.println("Provoli deleted");
        return null;
    }
    
    /**
     * 
     * @return an array of provoli objects.
     */
    public ProvoliService[] readAllProvoli() {
        System.out.println("read all the Provoli");
        return null;
    }
}
