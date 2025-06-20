import java.util.ArrayList;

public class Task {
    private String nama;
    private String deskripsi;
    private int prioritas;
    private String tenggat;
    private String status;
    private ArrayList<Task> subtugas;

    public Task(String nama, String deskripsi, int prioritas, String tenggat) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.prioritas = prioritas;
        this.tenggat = tenggat;
        this.status = "Belum";
        this.subtugas = new ArrayList<>();
    }

    public void tambahSubtugas(Task subtugasBaru) {
        subtugas.add(subtugasBaru);
    }

    public void tampilkan(int tingkat) {
        String indentasi = "  ".repeat(tingkat);
        System.out.println(indentasi + "- " + nama + " [" + status + "] (Prioritas: " + prioritas + ", Tenggat: " + tenggat + ")");
        System.out.println(indentasi + "  " + deskripsi);
        for (Task sub : subtugas) {
            sub.tampilkan(tingkat + 1);
        }
    }

    public void setStatus(String statusBaru) {
        this.status = statusBaru;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getPrioritas() {
        return prioritas;
    }

    public String getTenggat() {
        return tenggat;
    }

    public ArrayList<Task> getSubtugas() {
        return subtugas;
    }

    public void ubahTugas(String namaBaru, String deskripsiBaru, int prioritasBaru, String tenggatBaru, String statusBaru) {
        this.nama = namaBaru;
        this.deskripsi = deskripsiBaru;
        this.prioritas = prioritasBaru;
        this.tenggat = tenggatBaru;
        this.status = statusBaru;
    }

    public void hapusSubtugas(String namaSub) {
        subtugas.removeIf(t -> t.getNama().equalsIgnoreCase(namaSub));
    }

    public int hitungTotalTugas() {
        int total = 1; 
        for (Task sub : subtugas) {
            total += sub.hitungTotalTugas();
        }
        return total;
    }
}
