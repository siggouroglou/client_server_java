package gr.papei.mainpackage.server.service;

import gr.papei.mainpackage.server.data.*;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class AdminService extends UserService {

    public AdminService() {
        super();
    }
    
    /**
     * 
     * @param user The object that includes the criteria that will be used for searching. Criteria is every column is not having null value.
     * @return 
     */
    public UserService[] searchUser(UserService user){
        return null;
    }
    
    /**
     * Create a new UserService object.
     * @param user The new user that will be created.
     * @return the user object that has been created.
     */
    public UserService createUser(UserService user){
        System.out.println("User created");
        return null;
    }
    
    /**
     * Update an existing user.
     * @param id The id of the existing user that will be updated.
     * @param user The user that will replace the existing user.
     * @return The new updated user object.
     */
    public UserService updateUser(int id, UserService user){
        System.out.println("User updated");
        return null;
    }
    
    /**
     * Deletes a user.
     * @param user The user that will be deleted.
     * @return The user that was deleted.
     */
    public UserService deleteUser(UserService user){
        System.out.println("User deleted");
        return null;
    }
    
    /**
     * 
     * @return an array with all the existing users.
     */
    public UserService[] readAllUsers(){
        System.out.println("Read all Users");
        return null;
    }

}