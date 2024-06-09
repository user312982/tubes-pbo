package com.example.tubespbo.models;

import javafx.beans.property.*;

public class NilaiMapel {
    private FloatProperty nilaiTugas, nilaiUts, nilaiUas, nilaiAkhir;
    private IntegerProperty number, inputId;
    private StringProperty inputSiswa;

    public NilaiMapel(Float nilaiTugas, Float nilaiUts, Float nilaiUas, Float nilaiAkhir, Integer inputId, String inputSiswa) {
        this.nilaiTugas = new SimpleFloatProperty(nilaiTugas);
        this.nilaiUts = new SimpleFloatProperty(nilaiUts);
        this.nilaiUas = new SimpleFloatProperty(nilaiUas);
        this.nilaiAkhir = new SimpleFloatProperty(nilaiAkhir);
        this.number = new SimpleIntegerProperty();
        this.inputId = new SimpleIntegerProperty(inputId);
        this.inputSiswa = new SimpleStringProperty(inputSiswa);
    }


    public void setNilaiTugas(FloatProperty nilaiTugas) {
        this.nilaiTugas = nilaiTugas;
    }


    public void setNilaiUts(FloatProperty nilaiUts) {
        this.nilaiUts = nilaiUts;
    }

    public void setNilaiUas(FloatProperty nilaiUas) {
        this.nilaiUas = nilaiUas;
    }


    public void setNilaiAkhir(FloatProperty nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
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

    public FloatProperty nilaiTugasProperty(){
        return nilaiTugas;
    }

    public FloatProperty nilaiUtsProperty(){
        return nilaiUts;
    }

    public FloatProperty nilaiUasProperty(){
        return nilaiUas;
    }

    public FloatProperty nilaiAkhirProperty(){
        return nilaiAkhir;
    }

    public int getInputId() {
        return inputId.get();
    }

    public IntegerProperty inputIdProperty() {
        return inputId;
    }

    public void setInputId(int inputId) {
        this.inputId.set(inputId);
    }

    public String getInputSiswa() {
        return inputSiswa.get();
    }

    public StringProperty inputSiswaProperty() {
        return inputSiswa;
    }

    public void setInputSiswa(String inputSiswa) {
        this.inputSiswa.set(inputSiswa);
    }
}
