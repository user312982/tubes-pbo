package com.example.tubespbo.guru;

import com.example.tubespbo.Person;


public class Guru extends Person{
    public static Guru INSTANCE;


    public Guru(int storedId, String storedUsername, String storedAlamat, String NumberPhone, String storedCivitas) {
        super(storedId, storedUsername, storedAlamat, NumberPhone, storedCivitas);

    }

    public static Guru getInstance() {
        return INSTANCE;
    }

    public static void setINSTANCE(Guru guru) {
        INSTANCE = guru;
    }

    public void setStoredId(int storedId) {
        this.storedId = storedId;
    }

    public int getStoredId() {
        return this.storedId;
    }

    public void setStoredUsername(String storedUsername){
        this.storedUsername = storedUsername;
    }

    public String getStoredUsername(){
        return this.storedUsername;
    }

    public void setStoredAlamat(String alamatUser){
        this.storedAlamat = alamatUser;
    }

    public String getStoredAlamat(){
        return this.storedAlamat;
    }

    public void setPhoneNumber(String phoneNumber){
        this.storedPhoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.storedPhoneNumber;
    }

    public void setStoredCivitas(String storedCivitas){
        this.storedCivitas = storedCivitas;
    }

    public String getStoredCivitas(){
        return this.storedCivitas;
    }
}
