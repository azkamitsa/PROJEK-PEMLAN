import java.util.ArrayList;
import java.util.Scanner;

public class ManajerUser {
    
    private ArrayList<User> users;
    private User currentUser;

    public ManajerUser() {
    users = new ArrayList<>();
    currentUser = null;
}

public void registerUser(String username, String password, String role) {
    for (User u : users) {
        if (u.getUsername().equals(username)) {
            System.out.println("Username sudah digunakan.");
            return;
        }
    }
    users.add(new User(username, password, role));
    System.out.println("Registrasi berhasil.");
}

public boolean loginUser(String username, String password) {
    for (User u : users) {
        if (u.getUsername().equals(username) && u.checkPassword(password)) {
            currentUser = u;
            System.out.println("Login berhasil sebagai " + u.getUsername());
            return true;
        }
    }
    System.out.println("Login gagal: Username atau password salah.");
    return false;
}

public void logout() {
    if (currentUser != null) {
        System.out.println("Logout: " + currentUser.getUsername());
        currentUser = null;
    } else {
        System.out.println("Tidak ada pengguna yang sedang login.");
    }
}

public User getCurrentUser() {
    return currentUser;
}

public void listUsers() {
    System.out.println("Daftar Pengguna:");
    for (User u : users) {
        System.out.println(u);
    }
}

}

