package tubespbo;

public class MataPelajaran {
    private int idMapel;
    private String namaMapel;
    private String kelas;
    private String jurusan;
    private int jamPelajaran;
    
    public MataPelajaran(int idMapel, String namaMapel, String kelas, String jurusan, int jamPelajaran) {
        this.idMapel = idMapel;
        this.namaMapel = namaMapel;
        this.kelas = kelas;
        this.jurusan = jurusan;
        this.jamPelajaran = jamPelajaran;
    }

    public int getIdMapel() {
        return idMapel;
    }

    public void setIdMapel(int idMapel) {
        this.idMapel = idMapel;
    }

    public String getNamaMapel() {
        return namaMapel;
    }

    public void setNamaMapel(String namaMapel) {
        this.namaMapel = namaMapel;
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

    public int getJamPelajaran() {
        return jamPelajaran;
    }

    public void setJamPelajaran(int jamPelajaran) {
        this.jamPelajaran = jamPelajaran;
    }

    public static void main(String[] args) {
        MataPelajaran matapelajaran1 = new MataPelajaran(1, "Matematika", "XII-A", "IPA", 3);
        
        System.out.println("Informasi Mata Pelajaran:");
        System.out.println("ID Mata Pelajaran: " + matapelajaran1.getIdMapel());
        System.out.println("Nama Mata Pelajaran: " + matapelajaran1.getNamaMapel());
        System.out.println("Kelas: " + matapelajaran1.getKelas());
        System.out.println("Jurusan: " + matapelajaran1.getJurusan());
        System.out.println("Jam Pelajaran: " + matapelajaran1.getJamPelajaran());
    }
}
