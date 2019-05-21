package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Train implements Serializable {
    private Integer tr_id;
    private String tr_title;
    private String tr_context;
    private Date tr_start_time;
    private Date tr_end_time;
    private String tr_address;
    private String tr_is_publish;

    public Integer getTr_id() {
        return tr_id;
    }

    public void setTr_id(Integer tr_id) {
        this.tr_id = tr_id;
    }

    public String getTr_title() {
        return tr_title;
    }

    public void setTr_title(String tr_title) {
        this.tr_title = tr_title;
    }

    public String getTr_context() {
        return tr_context;
    }

    public void setTr_context(String tr_context) {
        this.tr_context = tr_context;
    }

    public Date getTr_start_time() {
        return tr_start_time;
    }

    public void setTr_start_time(Date tr_start_time) {
        this.tr_start_time = tr_start_time;
    }

    public Date getTr_end_time() {
        return tr_end_time;
    }

    public void setTr_end_time(Date tr_end_time) {
        this.tr_end_time = tr_end_time;
    }

    public String getTr_address() {
        return tr_address;
    }

    public void setTr_address(String tr_address) {
        this.tr_address = tr_address;
    }

    public String getTr_is_publish() {
        return tr_is_publish;
    }

    public void setTr_is_publish(String tr_is_publish) {
        this.tr_is_publish = tr_is_publish;
    }

    @Override
    public String toString() {
        return "Train{" +
                "tr_id=" + tr_id +
                ", tr_title='" + tr_title + '\'' +
                ", tr_context='" + tr_context + '\'' +
                ", tr_start_time=" + tr_start_time +
                ", tr_end_time=" + tr_end_time +
                ", tr_address='" + tr_address + '\'' +
                ", tr_is_publish='" + tr_is_publish + '\'' +
                '}';
    }
}
