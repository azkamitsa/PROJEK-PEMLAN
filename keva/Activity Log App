import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// ============== NODE UNTUK DOUBLE LINKED LIST ==============
class ActivityLogNode {
    private String action;
    private String details;
    private LocalDateTime timestamp;
    private String previousState; // Untuk undo functionality
    private ActivityLogNode next;
    private ActivityLogNode prev;

    public ActivityLogNode(String action, String details, String previousState) {
        this.action = action;
        this.details = details;
        this.previousState = previousState;
        this.timestamp = LocalDateTime.now();
        this.next = null;
        this.prev = null;
    }

    public ActivityLogNode(String action, String details) {
        this(action, details, null);
    }

    public String getAction() { return action; }
    public String getDetails() { return details; }
    public String getPreviousState() { return previousState; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public ActivityLogNode getNext() { return next; }
    public ActivityLogNode getPrev() { return prev; }

    public void setNext(ActivityLogNode next) { this.next = next; }
    public void setPrev(ActivityLogNode prev) { this.prev = prev; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("[%s] %s: %s",
                timestamp.format(formatter), action, details);
    }
}

// ============== DOUBLE LINKED LIST UNTUK ACTIVITY LOG ==============
class ActivityLog {
    private ActivityLogNode head;
    private ActivityLogNode tail;
    private ActivityLogNode current;
    private int size;
    private int maxSize = 50;

    public ActivityLog() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    public void addActivity(String action, String details, String previousState) {
        ActivityLogNode newNode = new ActivityLogNode(action, details, previousState);

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
            current = newNode;
        }

        size++;
        if (size > maxSize) {
            removeOldest();
        }
        System.out.println("Log added: " + action);
    }

    public void addActivity(String action, String details) {
        addActivity(action, details, null);
    }

    private void removeOldest() {
        if (head != null && head != tail) {
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
    }

    public void displayAllLogs() {
        if (head == null) {
            System.out.println("No activity logs found.");
            return;
        }

        System.out.println("\n=== ACTIVITY LOG (Forward Navigation) ===");
        ActivityLogNode node = head;
        int index = 1;

        while (node != null) {
            String indicator = (node == current) ? "  CURRENT" : "";
            System.out.println(index + ". " + node + indicator);
            node = node.getNext();
            index++;
        }
        System.out.println("Total logs: " + size);
    }

    public void displayLogsBackward() {
        if (tail == null) {
            System.out.println("No activity logs found.");
            return;
        }

        System.out.println("\n=== ACTIVITY LOG (Backward Navigation) ===");
        ActivityLogNode node = tail;
        int index = size;

        while (node != null) {
            String indicator = (node == current) ? " CURRENT" : "";
            System.out.println(index + ". " + node + indicator);
            node = node.getPrev();
            index--;
        }
        System.out.println("Total logs: " + size);
    }

    public void displayRecentLogs(int count) {
        if (tail == null) {
            System.out.println("No activity logs found.");
            return;
        }

        System.out.println("\n=== RECENT ACTIVITY LOG (" + count + " entries) ===");
        ActivityLogNode node = tail;
        int displayed = 0;

        while (node != null && displayed < count) {
            String indicator = (node == current) ? "  CURRENT" : "";
            System.out.println((displayed + 1) + ". " + node + indicator);
            node = node.getPrev();
            displayed++;
        }
    }

    public void navigatePrevious() {
        if (current != null && current.getPrev() != null) {
            current = current.getPrev();
            System.out.println("Navigated to previous: " + current.getAction());
        } else {
            System.out.println("Already at the beginning of log.");
        }
    }

    public void navigateNext() {
        if (current != null && current.getNext() != null) {
            current = current.getNext();
            System.out.println("Navigated to next: " + current.getAction());
        } else {
            System.out.println("Already at the end of log.");
        }
    }

    public void showCurrentPosition() {
        if (current == null) {
            System.out.println("No current position in log.");
            return;
        }

        int position = 1;
        ActivityLogNode node = head;
        while (node != null && node != current) {
            node = node.getNext();
            position++;
        }

        System.out.println("\nCURRENT POSITION: " + position + "/" + size);
        System.out.println("Current Activity: " + current);
        if (current.getPrev() != null) {
            System.out.println("Previous: " + current.getPrev().getAction());
        }
        if (current.getNext() != null) {
            System.out.println("Next: " + current.getNext().getAction());
        }
    }

    public boolean canUndo() {
        return current != null && current.getPrev() != null;
    }

    public boolean canRedo() {
        return current != null && current.getNext() != null;
    }

    public String undo() {
        if (!canUndo()) {
            return "Nothing to undo.";
        }
    
        String currentAction = current.getAction();
    
        if (current.getPreviousState() != null) { // Tampilkan informasi state sebelumnya (jika ada)
            System.out.println("Previous State: " + current.getPreviousState());
        }
        if (current.getPrev() != null) {
            System.out.println("Previous Action: " + current.getPrev().getAction());
        }
        current = current.getPrev();        // Pindah ke aksi sebelumnya
    
        String undoMessage = "Undone: " + currentAction;         // Tampilkan pesan undo
        if (current.getPreviousState() != null) {
            undoMessage += "\nRestored to: " + current.getPreviousState();
        }
    
        addActivity("UNDO", "Undone action: " + currentAction);
        return undoMessage;
    }

    public String redo() {
        if (!canRedo()) return "Nothing to redo.";
        current = current.getNext();
        return " Redone: " + current.getAction();
    }

    public void searchLogs(String keyword) {
        if (head == null) {
            System.out.println("No logs to search.");
            return;
        }

        System.out.println("\nSEARCH RESULTS for: '" + keyword + "'");
        ActivityLogNode node = head;
        int found = 0;
        int position = 1;

        while (node != null) {
            if (node.getAction().toLowerCase().contains(keyword.toLowerCase()) ||
                node.getDetails().toLowerCase().contains(keyword.toLowerCase())) {
                String indicator = (node == current) ? "  CURRENT" : "";
                System.out.println(position + ". " + node + indicator);
                found++;
            }
            node = node.getNext();
            position++;
        }

        if (found == 0) {
            System.out.println("No logs found containing: " + keyword);
        } else {
            System.out.println("Found " + found + " matching logs.");
        }
    }

    public void clearAllLogs() {
        head = tail = current = null;
        size = 0;
        System.out.println("All logs cleared.");
    }
}

public class ActivityLogApp {
    private static ActivityLog activityLog = new ActivityLog();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("ACTIVITY LOG DENGAN DOUBLE LINKED LIST");
        System.out.println("==========================================");
        System.out.println("Manajemen Log Aktivitas dengan Undo/Redo");

        while (true) {
            displayMenu();
            int choice = getIntInput("\nPilih menu: ");

            switch (choice) {
                case 1 -> addNewActivity();
                case 2 -> activityLog.displayAllLogs();
                case 3 -> activityLog.displayLogsBackward();
                case 4 -> {
                    int count = getIntInput("Tampilkan berapa log terbaru? ");
                    activityLog.displayRecentLogs(count);
                }
                case 5 -> activityLog.navigatePrevious();
                case 6 -> activityLog.navigateNext();
                case 7 -> activityLog.showCurrentPosition();
                case 8 -> undoRedoMenu();
                case 9 -> searchLogs();
                case 10 -> activityLog.clearAllLogs();
                case 0 -> {
                    System.out.println("Terima kasih!");
                    System.exit(0);
                }
                default -> System.out.println("Pilihan tidak valid!");
            }

            System.out.println("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
        }
    }

    private static void displayMenu() {
        System.out.println("\n============ MENU UTAMA ============");
        System.out.println("1.  Tambah Aktivitas Baru");
        System.out.println("2.  Tampilkan Semua Log (Forward)");
        System.out.println("3.  Tampilkan Semua Log (Backward)");
        System.out.println("4.  Tampilkan Log Terbaru");
        System.out.println("5.  Navigasi ke Log Sebelumnya");
        System.out.println("6.  Navigasi ke Log Berikutnya");
        System.out.println("7.  Tampilkan Posisi Current");
        System.out.println("8.  Menu Undo/Redo");
        System.out.println("9.  Cari Log");
        System.out.println("10. Hapus Semua Log");
        System.out.println("0.  Keluar");
        System.out.println("====================================");
    }

    private static void addNewActivity() {
        String action = getStringInput("Masukkan jenis aksi (ADD_TASK, EDIT_TASK, DELETE_TASK, dll): ");
        String details = getStringInput("Masukkan detail aktivitas: ");
        String previousState = getStringInput("Masukkan state sebelumnya (opsional, Enter untuk skip): ");

        if (previousState.trim().isEmpty()) {
            activityLog.addActivity(action, details);
        } else {
            activityLog.addActivity(action, details, previousState);
        }
    }

    private static void undoRedoMenu() {
        System.out.println("\nUNDO/REDO MENU");
        System.out.println("1. Undo ()");
        System.out.println("2. Redo ()");
        System.out.println("3. Cek Status Undo/Redo");

        int choice = getIntInput("Pilih: ");

        switch (choice) {
            case 1 -> System.out.println(activityLog.undo());
            case 2 -> System.out.println(activityLog.redo());
            case 3 -> {
                System.out.println("Can Undo: " + (activityLog.canUndo() ? " Yes" : " No"));
                System.out.println("Can Redo: " + (activityLog.canRedo() ? " Yes" : " No"));
            }
            default -> System.out.println(" Pilihan tidak valid!");
        }
    }

    private static void searchLogs() {
        String keyword = getStringInput("Masukkan kata kunci: ");
        activityLog.searchLogs(keyword);
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Input tidak valid. Masukkan angka.");
            }
        }
    }
}
