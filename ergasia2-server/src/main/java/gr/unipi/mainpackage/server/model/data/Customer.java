package gr.unipi.mainpackage.server.model.data;

import gr.unipi.mainpackage.server.lib.signin.SignInAbleUser;
import gr.unipi.mainpackage.server.lib.authority.Authority;
import static gr.unipi.mainpackage.server.lib.authority.Authority.*;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class Customer implements AuthorizedUser, SignInAbleUser {

    private String name;
    private String username;
    private String password;

    public Customer() {
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

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Customer can search and read for provoles, films, cinema rooms and they can search/create/read their reservations.
     * @return the available authorities list.
     */
    @Override
    public List<Authority> getAuthorities() {
        Authority[] authorityArray = new Authority[]{
            Provoli_S, Provoli_R,
            Film_S, Film_C,
            CinemaRoom_R,
            Reservation_S, Reservation_C, Reservation_R,
        };

        return Arrays.asList(authorityArray);
    }

}
