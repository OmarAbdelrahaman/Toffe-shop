import java.io.Serializable;
import java.util.ArrayList;

public class UsersList implements Serializable {
    private ArrayList<User> usersList = new ArrayList<>();
    public static User currentLoggedUser = null;

    public User register(String email, String password, String address){
        User user = new User(email, password, address);
        addUser(user);
        return user;
    }

    public void addUser(User user){
        usersList.add(user);
    }

    public ArrayList<User> findUserByEmail(String email){
        ArrayList<User> results = new ArrayList<>();
        for (User user : usersList) {
            if (user.getEmail().equals(email))
                results.add(user);
        }

        return results;
    }
    public String findAddress(String email){
        String results="1asf";
        for (User user : usersList) {
            if (user.getEmail().equals(email))
                results=user.getAddress();
        }
        return results;
    }


    public void saveToFile(){
        FileManager.save((Object) this.usersList, "Users");
    }

    public void setCurrentLoggedUser(User user){
        currentLoggedUser = user;
    }

    public User getCurrentLoggedUser() {
        return currentLoggedUser;
    }

    public static UsersList loadFromFile(){
        UsersList usersList1 = new UsersList();
        usersList1.usersList = (ArrayList<User>)FileManager.load("Users");
        return usersList1;
    }
}
