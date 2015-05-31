package gr.papei.mainpackage.server.model;

import gr.papei.mainpackage.server.lib.authority.Authority;
import static gr.papei.mainpackage.server.lib.authority.Authority.*;
import gr.papei.mainpackage.server.lib.authority.AuthorizedUser;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class Admin implements AuthorizedUser {

    private String name;
    private String username;
    private String password;

    public Admin() {
        this.name = "";
        this.username = "";
        this.password = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public List<Authority> getAuthorities() {
        Authority[] authorityArray = new Authority[]{
            Provoli_S, Provoli_C, Provoli_R, Provoli_U, Provoli_D,
            Film_S, Film_C, Film_R, Film_U, Film_D,
            CinemaRoom_S, CinemaRoom_C, CinemaRoom_R, CinemaRoom_U, CinemaRoom_D,
            Reservation_S, Reservation_C, Reservation_R, Reservation_U, Reservation_D,
            Customer_S, Customer_C, Customer_R, Customer_U, Customer_D,
            ContentAdmin_S, ContentAdmin_C, ContentAdmin_R, ContentAdmin_U, ContentAdmin_D,
            Admin_S, Admin_C, Admin_R, Admin_U, Admin_D
        };

        return Arrays.asList(authorityArray);
    }

}
