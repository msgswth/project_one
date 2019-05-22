package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Salary implements Serializable {
    private Integer s_id;
    private Integer emp_id;
    private Date s_date;//结算日期
    private Double s_perfor;//绩效奖金
    private Double s_extra;//加班费用
    private Double s_reward;//奖惩费用
    private Double s_insurance;//社保
    private Integer s_is_trouble;//复议状态

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Date getS_date() {
        return s_date;
    }

    public void setS_date(Date s_date) {
        this.s_date = s_date;
    }

    public Double getS_perfor() {
        return s_perfor;
    }

    public void setS_perfor(Double s_perfor) {
        this.s_perfor = s_perfor;
    }

    public Double getS_extra() {
        return s_extra;
    }

    public void setS_extra(Double s_extra) {
        this.s_extra = s_extra;
    }

    public Double getS_reward() {
        return s_reward;
    }

    public void setS_reward(Double s_reward) {
        this.s_reward = s_reward;
    }

    public Double getS_insurance() {
        return s_insurance;
    }

    public void setS_insurance(Double s_insurance) {
        this.s_insurance = s_insurance;
    }

    public Integer getS_is_trouble() {
        return s_is_trouble;
    }

    public void setS_is_trouble(Integer s_is_trouble) {
        this.s_is_trouble = s_is_trouble;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "s_id=" + s_id +
                ", emp_id=" + emp_id +
                ", s_date=" + s_date +
                ", s_perfor=" + s_perfor +
                ", s_extra=" + s_extra +
                ", s_reward=" + s_reward +
                ", s_insurance=" + s_insurance +
                ", s_is_trouble=" + s_is_trouble +
                '}';
    }
}
