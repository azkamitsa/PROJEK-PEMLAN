import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    //Linear Search berdasarkan judul atau deskripsi
    public void searchTask(String keyword) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Task tidak ditemukan.");
        }
    }

    //Bubble Sort berdasarkan prioritas (ascending)
    public void sortByPriority() {
        for (int i = 0; i < tasks.size() - 1; i++) {
            for (int j = 0; j < tasks.size() - i - 1; j++) {
                if (tasks.get(j).getPriority() > tasks.get(j + 1).getPriority()) {
                    // Swap
                    Task temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);
                }
            }
        }
        System.out.println("Tugas berhasil diurutkan berdasarkan prioritas!");
    }

    public void showAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
