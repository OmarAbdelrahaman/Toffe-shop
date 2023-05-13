public class Login {
    UsersList usersList;
    public Login(UsersList usersList){
        this.usersList = usersList;
    }
    private boolean doesUserExist(String email){
        return !usersList.findUserByEmail(email).isEmpty();
    }

    private boolean isPasswordCorrect(String email, String password){
        User user = usersList.findUserByEmail(email).get(0);
        String correctPassword = user.getPassword();
        return correctPassword.equals(password);
    }

    public boolean isLoginSuccessful(String email, String password){
        return doesUserExist(email) && isPasswordCorrect(email, password);
    }

}
