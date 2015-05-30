package gr.papei.mainpackage.server.data.model;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class User {
    private String name;
    private String username;
    private String password;

    public User() {
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
}
