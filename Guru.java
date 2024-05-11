package tubespbo;

public class Guru {
    private int idGuru;
    private String nama;
    private String nip;
    private String mataPelajaran;
    private String alamat;
    private String nomorTelepon;
    
    public Guru(int idGuru, String nama, String nip, String mataPelajaran, String alamat, String nomorTelepon) {
        this.idGuru = idGuru;
        this.nama = nama;
        this.nip = nip;
        this.mataPelajaran = mataPelajaran;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }

    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public static void main(String[] args) {
        Guru guru1 = new Guru(1, "Bagus", "54321", "Matematika", "Jl. Contoh No. 456", "081234567891");
        
        System.out.println("Informasi Guru:");
        System.out.println("ID Guru: " + guru1.getIdGuru());
        System.out.println("Nama: " + guru1.getNama());
        System.out.println("NIP: " + guru1.getNip());
        System.out.println("Mata Pelajaran: " + guru1.getMataPelajaran());
        System.out.println("Alamat: " + guru1.getAlamat());
        System.out.println("Nomor Telepon: " + guru1.getNomorTelepon());
    }
}
