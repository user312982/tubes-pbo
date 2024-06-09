package com.example.tubespbo.models;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class AbsensiSiswa {
    private final ObjectProperty<LocalDate> tanggal;
    private final ObjectProperty<LocalTime> jam;
    private final StringProperty nama;
    private final StringProperty status;
    private final IntegerProperty nis;

    public AbsensiSiswa(LocalDate tanggal, LocalTime jam, String nama, String status, int nis) {
        this.tanggal = new SimpleObjectProperty<>(tanggal);
        this.jam = new SimpleObjectProperty<>(jam);
        this.nama = new SimpleStringProperty(nama);
        this.status = new SimpleStringProperty(status);
        this.nis = new SimpleIntegerProperty(nis);
    }

    public LocalDate getTanggal() {
        return tanggal.get();
    }

    public ObjectProperty<LocalDate> tanggalProperty() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal.set(tanggal);
    }

    public LocalTime getJam() {
        return jam.get();
    }

    public ObjectProperty<LocalTime> jamProperty() {
        return jam;
    }

    public void setJam(LocalTime jam) {
        this.jam.set(jam);
    }

    public String getNama() {
        return nama.get();
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public int getNis() {
        return nis.get();
    }

    public IntegerProperty nisProperty() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis.set(nis);
    }
}
