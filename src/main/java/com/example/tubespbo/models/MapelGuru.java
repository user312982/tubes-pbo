package com.example.tubespbo.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MapelGuru {
    private StringProperty mapel;
    private IntegerProperty nip;
    private IntegerProperty number;

    public MapelGuru(Integer nip, String mapel) {
        this.mapel = new SimpleStringProperty(mapel);
        this.nip = new SimpleIntegerProperty(nip);
        this.number = new SimpleIntegerProperty();
    }

    public String getMapel() {
        return mapel.get();
    }

    public StringProperty mapelProperty() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel.set(mapel);
    }

    public int getNip() {
        return nip.get();
    }

    public IntegerProperty nipProperty() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip.set(nip);
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public int getNumber() {
        return number.get();
    }

    public void setNumber(int number) {
        this.number.set(number);
    }
}
