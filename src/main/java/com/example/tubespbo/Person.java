package com.example.tubespbo;

public abstract class Person {
    protected int storedId;
    protected String storedUsername;
    protected String storedAlamat;
    protected String storedPhoneNumber;

    public Person(int storedId, String storedUsername, String storedAlamat, String storedPhoneNumber) {
        this.storedId = storedId;
        this.storedUsername = storedUsername;
        this.storedAlamat = storedAlamat;
        this.storedPhoneNumber = storedPhoneNumber;
    }

    public abstract void setStoredId(int storedId);
    public abstract int getStoredId();

    public abstract void setStoredUsername(String storedUsername);
    public abstract String getStoredUsername();

    public abstract void setStoredAlamat(String storedAlamat);
    public abstract String getStoredAlamat();

    public abstract void setPhoneNumber(String PhoneNumber);
    public abstract String getPhoneNumber();
}

