package tubespbo;

public class Jadwal {
    private int idJadwal;
    private int idGuru;
    private int idMapel;
    private String hari;
    private String jamMulai;
    private String jamSelesai;
    
    public Jadwal(int idJadwal, int idGuru, int idMapel, String hari, String jamMulai, String jamSelesai) {
        this.idJadwal = idJadwal;
        this.idGuru = idGuru;
        this.idMapel = idMapel;
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    public int getIdMapel() {
        return idMapel;
    }

    public void setIdMapel(int idMapel) {
        this.idMapel = idMapel;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public static void main(String[] args) {
        Jadwal jadwal1 = new Jadwal(1, 1, 1, "Senin", "08:00", "10:00");
        
        System.out.println("Informasi Jadwal:");
        System.out.println("ID Jadwal: " + jadwal1.getIdJadwal());
        System.out.println("ID Guru: " + jadwal1.getIdGuru());
        System.out.println("ID Mata Pelajaran: " + jadwal1.getIdMapel());
        System.out.println("Hari: " + jadwal1.getHari());
        System.out.println("Jam Mulai: " + jadwal1.getJamMulai());
        System.out.println("Jam Selesai: " + jadwal1.getJamSelesai());
    }
}
