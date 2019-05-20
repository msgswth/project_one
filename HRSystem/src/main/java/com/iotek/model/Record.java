package com.iotek.model;

import java.io.Serializable;

public class Record implements Serializable {
    private Tourist tourist;
    private Interview interview;
    private Recruit recruit;

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Recruit getRecruit() {
        return recruit;
    }

    public void setRecruit(Recruit recruit) {
        this.recruit = recruit;
    }

    @Override
    public String toString() {
        return "Record{" +
                "tourist=" + tourist +
                ", interview=" + interview +
                ", recruit=" + recruit +
                '}';
    }
}
