package tubespbo;

public class Absensi {
    private int idAbsensi;
    private int idSiswa;
    private int idJadwal;
    private String tanggal;
    private String statusKehadiran;
    
    public Absensi(int idAbsensi, int idSiswa, int idJadwal, String tanggal, String statusKehadiran) {
        this.idAbsensi = idAbsensi;
        this.idSiswa = idSiswa;
        this.idJadwal = idJadwal;
        this.tanggal = tanggal;
        this.statusKehadiran = statusKehadiran;
    }

    public int getIdAbsensi() {
        return idAbsensi;
    }

    public void setIdAbsensi(int idAbsensi) {
        this.idAbsensi = idAbsensi;
    }

    public int getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatusKehadiran() {
        return statusKehadiran;
    }

    public void setStatusKehadiran(String statusKehadiran) {
        this.statusKehadiran = statusKehadiran;
    }

    public static void main(String[] args) {
        Absensi absensi1 = new Absensi(1, 1, 1, "2024-04-30", "Hadir");
        
        System.out.println("Informasi Absensi:");
        System.out.println("ID Absensi: " + absensi1.getIdAbsensi());
        System.out.println("ID Siswa: " + absensi1.getIdSiswa());
        System.out.println("ID Jadwal: " + absensi1.getIdJadwal());
        System.out.println("Tanggal: " + absensi1.getTanggal());
        System.out.println("Status Kehadiran: " + absensi1.getStatusKehadiran());
    }
}
