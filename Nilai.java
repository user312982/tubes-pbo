package tubespbo;

public class Nilai {
    private int idNilai;
    private int idSiswa;
    private int idMapel;
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;
    private double nilaiAkhir;
    
    public Nilai(int idNilai, int idSiswa, int idMapel, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.idNilai = idNilai;
        this.idSiswa = idSiswa;
        this.idMapel = idMapel;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        this.nilaiAkhir = hitungNilaiAkhir();
    }

    public int getIdNilai() {
        return idNilai;
    }

    public void setIdNilai(int idNilai) {
        this.idNilai = idNilai;
    }

    public int getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    public int getIdMapel() {
        return idMapel;
    }

    public void setIdMapel(int idMapel) {
        this.idMapel = idMapel;
    }

    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public void setNilaiTugas(double nilaiTugas) {
        this.nilaiTugas = nilaiTugas;
    }

    public double getNilaiUTS() {
        return nilaiUTS;
    }

    public void setNilaiUTS(double nilaiUTS) {
        this.nilaiUTS = nilaiUTS;
    }

    public double getNilaiUAS() {
        return nilaiUAS;
    }

    public void setNilaiUAS(double nilaiUAS) {
        this.nilaiUAS = nilaiUAS;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir;
    }

    public void setNilaiAkhir(double nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    
    private double hitungNilaiAkhir() {
        return (nilaiTugas + nilaiUTS + nilaiUAS) / 3.0;
    }

    public static void main(String[] args) {
        Nilai nilai1 = new Nilai(1, 1, 1, 80.0, 85.0, 90.0);
        
        System.out.println("Informasi Nilai:");
        System.out.println("ID Nilai: " + nilai1.getIdNilai());
        System.out.println("ID Siswa: " + nilai1.getIdSiswa());
        System.out.println("ID Mata Pelajaran: " + nilai1.getIdMapel());
        System.out.println("Nilai Tugas: " + nilai1.getNilaiTugas());
        System.out.println("Nilai UTS: " + nilai1.getNilaiUTS());
        System.out.println("Nilai UAS: " + nilai1.getNilaiUAS());
        System.out.println("Nilai Akhir: " + nilai1.getNilaiAkhir());
    }
}

