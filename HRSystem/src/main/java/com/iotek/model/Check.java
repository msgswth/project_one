package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Check implements Serializable {
    private Integer ch_id;
    private Integer emp_id;
    private Date ch_start_time;
    private Date ch_end_time;

    public Integer getCh_id() {
        return ch_id;
    }

    public void setCh_id(Integer ch_id) {
        this.ch_id = ch_id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Date getCh_start_time() {
        return ch_start_time;
    }

    public void setCh_start_time(Date ch_start_time) {
        this.ch_start_time = ch_start_time;
    }

    public Date getCh_end_time() {
        return ch_end_time;
    }

    public void setCh_end_time(Date ch_end_time) {
        this.ch_end_time = ch_end_time;
    }

    @Override
    public String toString() {
        return "Check{" +
                "ch_id=" + ch_id +
                ", emp_id=" + emp_id +
                ", ch_start_time=" + ch_start_time +
                ", ch_end_time=" + ch_end_time +
                '}';
    }
}
