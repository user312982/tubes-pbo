package com.example.tubespbo;

public abstract class Person {
    public int storedId;
    public String storedUsername;
    public String storedAlamat;
    public String storedPhoneNumber;
    public String storedCivitas;

    public Person(int storedId, String storedUsername, String storedAlamat, String storedPhoneNumber, String storedCivitas) {
        this.storedId = storedId;
        this.storedUsername = storedUsername;
        this.storedAlamat = storedAlamat;
        this.storedPhoneNumber = storedPhoneNumber;
        this.storedCivitas = storedCivitas;
    }

    public abstract void setStoredId(int storedId);
    public abstract int getStoredId();

    public abstract void setStoredUsername(String storedUsername);
    public abstract String getStoredUsername();

    public abstract void setStoredAlamat(String storedAlamat);
    public abstract String getStoredAlamat();

    public abstract void setPhoneNumber(String PhoneNumber);
    public abstract String getPhoneNumber();

    public abstract void setStoredCivitas(String storedCivitas);
    public abstract String getStoredCivitas();
}

