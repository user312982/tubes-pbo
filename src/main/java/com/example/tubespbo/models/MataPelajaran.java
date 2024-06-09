package com.example.tubespbo.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MataPelajaran {
    private StringProperty mapel, kelas, jurusan;
    private IntegerProperty number;

    public MataPelajaran(String mapel, String kelas, String jurusan) {
        this.mapel = new SimpleStringProperty(mapel);
        this.kelas = new SimpleStringProperty(kelas);
        this.jurusan = new SimpleStringProperty(jurusan);
        this.number = new SimpleIntegerProperty();
    }

    public StringProperty getMapel() {
        return mapel;
    }

    public void setMapel(StringProperty mapel) {
        this.mapel = mapel;
    }

    public StringProperty getKelas(){
        return kelas;
    }

    public void setKelas(StringProperty kelas) {
        this.kelas = kelas;
    }

    public StringProperty getJurusan() {
        return jurusan;
    }

    public void setJurusan(StringProperty jurusan) {
        this.jurusan = jurusan;
    }

    public IntegerProperty getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public IntegerProperty numberProperty(){
        return number;
    }

    public StringProperty kelasProperty() {
        return kelas;
    }

    public StringProperty mapelProperty() {
        return mapel;
    }

    public StringProperty jurusanProperty() {
        return jurusan;
    }

}
