package gr.unipi.mainpackage.server.model.data;

import gr.unipi.mainpackage.server.lib.signin.SignInAbleUser;
import gr.unipi.mainpackage.server.lib.authority.Authority;
import static gr.unipi.mainpackage.server.lib.authority.Authority.*;
import gr.unipi.mainpackage.server.lib.authority.AuthorizedUser;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class ContentAdmin implements AuthorizedUser, SignInAbleUser {

    private String name;
    private String username;
    private String password;

    public ContentAdmin() {
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
     * ContentAdmins can manage provoles, films and cinema rooms (content data).
     * @return the available authorities list.
     */
    @Override
    public List<Authority> getAuthorities() {
        Authority[] authorityArray = new Authority[]{
            Provoli_S, Provoli_C, Provoli_R, Provoli_U, Provoli_D,
            Film_S, Film_C, Film_R, Film_U, Film_D,
            CinemaRoom_S, CinemaRoom_C, CinemaRoom_R, CinemaRoom_U, CinemaRoom_D
        };

        return Arrays.asList(authorityArray);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContentAdmin other = (ContentAdmin) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

}
