import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ManajerUser manajer = new ManajerUser();
        int choice;
    do {
        System.out.println("\n=== Menu TaskBuddy ===");
        System.out.println("1. Daftar Pengguna");
        System.out.println("2. Login");
        System.out.println("3. Logout");
        System.out.println("4. Lihat Pengguna Aktif");
        System.out.println("5. Daftar Semua Pengguna");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu: ");
        choice = sc.nextInt();
        sc.nextLine(); // buang newline

        switch (choice) {
            case 1:
                System.out.print("Masukkan username: ");
                String regUser = sc.nextLine();
                System.out.print("Masukkan password: ");
                String regPass = sc.nextLine();
                System.out.print("Sebagai (admin/user): ");
                String regRole = sc.nextLine();
                manajer.registerUser(regUser, regPass, regRole);
                break;
            case 2:
                System.out.print("Username: ");
                String logUser = sc.nextLine();
                System.out.print("Password: ");
                String logPass = sc.nextLine();
                manajer.loginUser(logUser, logPass);
                break;
            case 3:
                manajer.logout();
                break;
            case 4:
                User current = manajer.getCurrentUser();
                if (current != null) {
                    System.out.println("Pengguna aktif: " + current);
                } else {
                    System.out.println("Belum ada user yang login.");
                }
                break;
            case 5:
                manajer.listUsers();
                break;
            case 6:
                System.out.println("Keluar dari program.");
                break;
            default:
                System.out.println("Menu tidak valid.");
        }
    } while (choice != 6);

    sc.close();
}

}
