package com.example.tubespbo;

public class UserData {
    public static UserData INSTANCE;

    public int storedId;
    public String storedUsername, storedAlamat, storedPhoneNumber;

    public UserData(int storedId, String storedUsername, String storedAlamat, String storedPhoneNumber) {
        this.storedId = storedId;
        this.storedUsername = storedUsername;
        this.storedAlamat = storedAlamat;
        this.storedPhoneNumber = storedPhoneNumber;
    }

    public static UserData getInstance() {
        return INSTANCE;
    }

    public static void setINSTANCE(UserData userData) {
        INSTANCE = userData;
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
