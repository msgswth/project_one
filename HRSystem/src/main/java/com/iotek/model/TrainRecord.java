package com.iotek.model;

import java.io.Serializable;

public class TrainRecord implements Serializable {
    private Integer td_id;
    private Integer emp_id;
    private Integer tr_id;

    public Integer getTd_id() {
        return td_id;
    }

    public void setTd_id(Integer td_id) {
        this.td_id = td_id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Integer getTr_id() {
        return tr_id;
    }

    public void setTr_id(Integer tr_id) {
        this.tr_id = tr_id;
    }

    @Override
    public String toString() {
        return "TrainRecord{" +
                "td_id=" + td_id +
                ", emp_id=" + emp_id +
                ", tr_id=" + tr_id +
                '}';
    }
}
