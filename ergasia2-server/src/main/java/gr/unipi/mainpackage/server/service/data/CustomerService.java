package gr.unipi.mainpackage.server.service.data;

import gr.unipi.mainpackage.server.lib.signin.SignInAbleService;
import gr.unipi.mainpackage.server.lib.signin.SignInAbleUser;
import gr.unipi.mainpackage.server.lib.authority.Authority;
import gr.unipi.mainpackage.server.lib.authority.AuthorityUtils;
import gr.unipi.mainpackage.server.lib.authority.AuthorizationException;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import gr.unipi.mainpackage.server.model.Customer;
import java.util.List;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class CustomerService implements SignInAbleService {

    public CustomerService() {
        super();
    }

    /**
     *
     * @param customer The object that includes the criteria that will be used for
     * searching. Criteria is every column is not having null value.
     * @param user 
     * @return
     */
    public List<Customer> searchCustomer(Customer customer, AuthorizedUser user) {
        // Check the arguments.
        if (customer == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Customer_S, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        return null;
    }

    /**
     * Create a new Customer object.
     *
     * @param customer The new user that will be created.
     * @param user
     * @return the user object that has been created.
     */
    public Customer createCustomer(Customer customer, AuthorizedUser user) {
        // Check the arguments.
        if (customer == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Customer_C, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("User created");
        return null;
    }

    /**
     * Update an existing user.
     *
     * @param id The id of the existing user that will be updated.
     * @param customer The user that will replace the existing user.
     * @param user 
     * @return The new updated user object.
     */
    public Customer updateCustomer(int id, Customer customer, AuthorizedUser user) {
        // Check the arguments.
        if (customer == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Customer_U, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("User updated");
        return null;
    }

    /**
     * Deletes a user.
     *
     * @param customer The user that will be deleted.
     * @param user 
     * @return The user that was deleted.
     */
    public Customer deleteCustomer(Customer customer, AuthorizedUser user) {
        // Check the arguments.
        if (customer == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Customer_D, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("User deleted");
        return null;
    }

    /**
     *
     * @param customer
     * @param user
     * @return an array with all the existing users.
     */
    public List<Customer> readCustomer(Customer customer, AuthorizedUser user) {
        // Check the arguments.
        if (customer == null || user == null) {
            throw new IllegalArgumentException("Null arguments.");
        }
        // Check the user authorization.
        if (!AuthorityUtils.hasAuthority(Authority.Customer_R, user)) {
            throw new AuthorizationException("User does not have the requires permissions.");
        }
        
        // Implement the code.
        System.out.println("Read all Users");
        return null;
    }
    
    @Override
    public boolean login(SignInAbleUser user){
        return true;
    }
    
    @Override
    public boolean logout(SignInAbleUser user){
        return true;
    }
}
