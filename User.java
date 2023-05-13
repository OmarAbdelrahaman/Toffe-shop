import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String email;
    private String password;
    private String address;
    private boolean loggedIn;


    public User(String email, String password, String address) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.loggedIn = false;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}