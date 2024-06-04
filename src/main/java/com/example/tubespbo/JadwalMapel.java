package com.example.tubespbo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class JadwalMapel {
    private StringProperty day, startTime, endTime;
    private MataPelajaran studySubjects;
    private IntegerProperty number;

    private StringProperty studySubjectsProperty = new SimpleStringProperty();

    public JadwalMapel(String day, String startTime, String endTime, MataPelajaran studySubjects) {
        this.day = new SimpleStringProperty(day);
        this.startTime = new SimpleStringProperty(startTime);
        this.endTime = new SimpleStringProperty(endTime);
        this.studySubjects = studySubjects;
        this.number = new SimpleIntegerProperty();

        this.studySubjectsProperty.set(studySubjects.getMapel().get());
    }

    public StringProperty getDay() {
        return day;
    }

    public void setDay(StringProperty day) {
        this.day = day;
    }

    public StringProperty getStartTime() {
        return startTime;
    }

    public void setStartTime(StringProperty startTime) {
        this.startTime = startTime;
    }

    public StringProperty getEndTime() {
        return endTime;
    }

    public void setEndTime(StringProperty endTime) {
        this.endTime = endTime;
    }


    public IntegerProperty getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public StringProperty dayProperty() {
        return day;
    }

    public StringProperty startTimeProperty() {
        return startTime;
    }

    public StringProperty endTimeProperty() {
        return endTime;
    }

    // Getter dan Setter untuk studySubjects
    public MataPelajaran getStudySubjects() {
        return studySubjects;
    }

    public void setStudySubjects(MataPelajaran studySubjects) {
        this.studySubjects = studySubjects;

        // Tetapkan kembali nilai properti studySubjectsProperty saat studySubjects diubah
        this.studySubjectsProperty.set(studySubjects.getMapel().get());
    }

    // Getter untuk studySubjectsProperty
    public StringProperty studySubjectsProperty() {
        return studySubjectsProperty;
    }


}
