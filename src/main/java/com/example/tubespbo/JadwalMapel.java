package com.example.tubespbo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JadwalMapel {
//    private String day, startTime, endTime;
    private StringProperty day,startTime, endTime, studySubjects;
    private IntegerProperty number;

    public JadwalMapel(String day, String startTime, String endTime, String studySubjects) {
        this.day = new SimpleStringProperty(day);
        this.startTime = new SimpleStringProperty(startTime);
        this.endTime = new SimpleStringProperty(endTime);
        this.studySubjects = new SimpleStringProperty(studySubjects);
        this.number = new SimpleIntegerProperty();
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

    public String getStudySubjects() {
        return studySubjects.get();
    }

    public StringProperty studySubjectsProperty() {
        return studySubjects;
    }

    public void setStudySubjects(String studySubjects) {
        this.studySubjects.set(studySubjects);
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

    public StringProperty dayProperty() {
        return day;
    }

    public StringProperty startTimeProperty() {
        return startTime;
    }

    public StringProperty endTimeProperty() {
        return endTime;
    }
}
