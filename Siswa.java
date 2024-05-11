package tubespbo;

public class Siswa {
    private int idSiswa;
    private String nama;
    private String nis;
    private String kelas;
    private String jurusan;
    private String alamat;
    private String nomorTelepon;
    
    public Siswa(int idSiswa, String nama, String nis, String kelas, String jurusan, String alamat, String nomorTelepon) {
        this.idSiswa = idSiswa;
        this.nama = nama;
        this.nis = nis;
        this.kelas = kelas;
        this.jurusan = jurusan;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }

    
    public int getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
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
        
        Siswa siswa1 = new Siswa(11231010, "Andi Zalfa", "12345", "XII-A", "IPA", "Jl. PJHI No. 123", "081234567890");
        
        
        System.out.println("Informasi Siswa:");
        System.out.println("ID Siswa: " + siswa1.getIdSiswa());
        System.out.println("Nama: " + siswa1.getNama());
        System.out.println("NIS: " + siswa1.getNis());
        System.out.println("Kelas: " + siswa1.getKelas());
        System.out.println("Jurusan: " + siswa1.getJurusan());
        System.out.println("Alamat: " + siswa1.getAlamat());
        System.out.println("Nomor Telepon: " + siswa1.getNomorTelepon());
    }
}
