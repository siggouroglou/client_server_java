package gr.papei.mainpackage.server.data;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class Admin extends User {

    public Admin() {
        super();
    }
    
    /**
     * 
     * @param user The object that includes the criteria that will be used for searching. Criteria is every column is not having null value.
     * @return 
     */
    public User[] searchUser(User user){
        return null;
    }
    
    /**
     * Create a new User object.
     * @param user The new user that will be created.
     * @return the user object that has been created.
     */
    public User createUser(User user){
        System.out.println("User created");
        return null;
    }
    
    /**
     * Update an existing user.
     * @param id The id of the existing user that will be updated.
     * @param user The user that will replace the existing user.
     * @return The new updated user object.
     */
    public User updateUser(int id, User user){
        System.out.println("User updated");
        return null;
    }
    
    /**
     * Deletes a user.
     * @param user The user that will be deleted.
     * @return The user that was deleted.
     */
    public User deleteUser(User user){
        System.out.println("User deleted");
        return null;
    }
    
    /**
     * 
     * @return an array with all the existing users.
     */
    public User[] readAllUsers(){
        System.out.println("Read all Users");
        return null;
    }

}