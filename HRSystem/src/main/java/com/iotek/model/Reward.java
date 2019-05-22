package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Reward implements Serializable {
    private Integer r_id;
    private Integer emp_id;
    private Date r_date;
    private String r_reason;
    private Double r_money;

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public String getR_reason() {
        return r_reason;
    }

    public void setR_reason(String r_reason) {
        this.r_reason = r_reason;
    }

    public Double getR_money() {
        return r_money;
    }

    public void setR_money(Double r_money) {
        this.r_money = r_money;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "r_id=" + r_id +
                ", emp_id=" + emp_id +
                ", r_date=" + r_date +
                ", r_reason='" + r_reason + '\'' +
                ", r_money=" + r_money +
                '}';
    }
}
