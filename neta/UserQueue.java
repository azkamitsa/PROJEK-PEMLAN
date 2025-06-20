import java.util.LinkedList;
import java.util.Queue;

class User {
    private String username;
    private String tugas;

    public User(String username, String tugas) {
        this.username = username;
        this.tugas = tugas;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return tugas;
    }

    public void display() {
        System.out.println("User bernama" + username + "dengan nama tugas" + tugas + "");
    }
}

class UserQueue {
    private Queue<User> userQueue;

    public UserQueue() {
        userQueue = new LinkedList<>();
    }

    public void enqueue(User user) {
        userQueue.add(user);
        System.out.println("User " + user.getUsername() + " masuk ke dalam waiting list.");
    }

    public User dequeue() {
        if (userQueue.isEmpty()) {
            System.out.println("Antrian kosong!");
            return null;
        }
        return userQueue.poll();
    }

    public boolean isEmpty() {
        return userQueue.isEmpty();
    }

    public int size() {
        return userQueue.size();
    }
}
