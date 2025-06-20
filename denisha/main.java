public class Main {
    public static void main(String[] args) {
        Task tugasUtama = new Task("Projek Akhir", "membuat website", 3, "2025-06-30");

        Task strukturTree = new Task("Tugas 1", "membuat desain ui", 3, "2025-06-20");
        Task logAktivitas = new Task("Tugas 2", "perlu perbaikan", 2, "2025-06-29");

        tugasUtama.tambahSubtugas(strukturTree);
        tugasUtama.tambahSubtugas(logAktivitas);

        Task subtugas = new Task("Membuat kodingan", "sudah oke", 2, "2025-06-15");
        strukturTree.tambahSubtugas(subtugas);

        System.out.println("\n \t -- Daftar Tugas sebelum diperbarui --");
        tugasUtama.tampilkan(0);

        strukturTree.ubahTugas("Tugas 1 (Revisi)", "membuat ulang essay", 4, "2025-06-25", "Dalam Proses");

        strukturTree.hapusSubtugas("membuat video");

        int total = tugasUtama.hitungTotalTugas();
        System.out.println("\nTotal semua tugas: " + total);

        System.out.println("\n \t -- Daftar Tugas setelah diperbarui --");
        tugasUtama.tampilkan(0);
    }
}
