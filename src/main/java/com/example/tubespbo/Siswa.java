package com.example.tubespbo;

public class Siswa extends Person{
    public static Siswa INSTANCE;

    public Siswa(int storedId, String storedUsername, String storedAlamat, String NumberPhone) {
        super(storedId, storedUsername, storedAlamat, NumberPhone);
    }

    public static Siswa getInstance() {
        return INSTANCE;
    }

    public static void setINSTANCE(Siswa siswa) {
        INSTANCE = siswa;
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
}
