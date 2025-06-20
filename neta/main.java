import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        UserQueue userQueue = new UserQueue();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah user yang diinginkan : ");
        int jumlahUser = scanner.nextInt();
        scanner.nextLine();

        // ini buat bisa input user 1 by 1
        for (int i = 0; i < jumlahUser; i++) {
            System.out.println("\nUser ke-" + (i + 1));
            System.out.print("Masukkan nama user: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan daftar nama tugas yang dikerjakan : ");
            String tugas = scanner.nextLine();

            userQueue.enqueue(new User(nama, tugas));
        }

        // ini biar bs prosses user 1 by 1
        System.out.println("\n Memproses waiting list user \n");
        while (!userQueue.isEmpty()) {
            User activeUser = userQueue.dequeue();
            if (activeUser != null) {
                activeUser.display();
                System.out.print("Click enter untuk bisa lanjut ke next user ...");
                scanner.nextLine();
            }
        }

        System.out.println("\nAll user has been processed, Thank u!");
    }
}
