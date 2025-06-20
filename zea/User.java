public class User {
    private String username;
    private String password;
    private String person;

    public User(String username, String password, String who){
        this.username = username;
        this.password = password;
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public String getWho () {
        return person;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    @Override
    public String toString() {
        return "User: " + username;
    }
}
