public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task("Belajar Java", "OOP dan struktur data", 2, "2025-06-25"));
        manager.addTask(new Task("Laporan Praktikum", "Selesaiin TaskBuddy", 1, "2025-06-20"));
        manager.addTask(new Task("Nonton Drama", "Relax after ngoding", 5, "2025-06-30"));

        System.out.println("Semua tugas:");
        manager.showAllTasks();

        System.out.println("\nCari tugas dengan kata 'praktikum':");
        manager.searchTask("praktikum");

        System.out.println("\nUrutkan berdasarkan prioritas:");
        manager.sortByPriority();
        manager.showAllTasks();
    }
}
