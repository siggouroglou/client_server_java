package gr.papei.mainpackage.server.model;

import gr.papei.mainpackage.server.lib.authority.Authority;
import static gr.papei.mainpackage.server.lib.authority.Authority.CinemaRoom_C;
import static gr.papei.mainpackage.server.lib.authority.Authority.CinemaRoom_D;
import static gr.papei.mainpackage.server.lib.authority.Authority.CinemaRoom_R;
import static gr.papei.mainpackage.server.lib.authority.Authority.CinemaRoom_S;
import static gr.papei.mainpackage.server.lib.authority.Authority.CinemaRoom_U;
import static gr.papei.mainpackage.server.lib.authority.Authority.ContentAdmin_C;
import static gr.papei.mainpackage.server.lib.authority.Authority.ContentAdmin_D;
import static gr.papei.mainpackage.server.lib.authority.Authority.ContentAdmin_R;
import static gr.papei.mainpackage.server.lib.authority.Authority.ContentAdmin_S;
import static gr.papei.mainpackage.server.lib.authority.Authority.ContentAdmin_U;
import static gr.papei.mainpackage.server.lib.authority.Authority.Customer_C;
import static gr.papei.mainpackage.server.lib.authority.Authority.Customer_D;
import static gr.papei.mainpackage.server.lib.authority.Authority.Customer_R;
import static gr.papei.mainpackage.server.lib.authority.Authority.Customer_S;
import static gr.papei.mainpackage.server.lib.authority.Authority.Customer_U;
import static gr.papei.mainpackage.server.lib.authority.Authority.Film_C;
import static gr.papei.mainpackage.server.lib.authority.Authority.Film_D;
import static gr.papei.mainpackage.server.lib.authority.Authority.Film_R;
import static gr.papei.mainpackage.server.lib.authority.Authority.Film_S;
import static gr.papei.mainpackage.server.lib.authority.Authority.Film_U;
import static gr.papei.mainpackage.server.lib.authority.Authority.Provoli_C;
import static gr.papei.mainpackage.server.lib.authority.Authority.Provoli_D;
import static gr.papei.mainpackage.server.lib.authority.Authority.Provoli_R;
import static gr.papei.mainpackage.server.lib.authority.Authority.Provoli_S;
import static gr.papei.mainpackage.server.lib.authority.Authority.Provoli_U;
import static gr.papei.mainpackage.server.lib.authority.Authority.Reservation_C;
import static gr.papei.mainpackage.server.lib.authority.Authority.Reservation_D;
import static gr.papei.mainpackage.server.lib.authority.Authority.Reservation_R;
import static gr.papei.mainpackage.server.lib.authority.Authority.Reservation_S;
import static gr.papei.mainpackage.server.lib.authority.Authority.Reservation_U;
import gr.papei.mainpackage.server.lib.authority.AuthorizedUser;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class Customer implements AuthorizedUser {

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