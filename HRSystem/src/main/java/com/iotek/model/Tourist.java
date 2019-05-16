package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Tourist implements Serializable {
    private Integer t_id;
    private String t_name;
    private String t_pass;
    private String t_gender;
    private Date t_birth;
    private String t_phone;
    private String t_email;
    private String t_address;
    private Integer resume_id;//简历的id

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_pass() {
        return t_pass;
    }

    public void setT_pass(String t_pass) {
        this.t_pass = t_pass;
    }

    public String getT_gender() {
        return t_gender;
    }

    public void setT_gender(String t_gender) {
        this.t_gender = t_gender;
    }

    public Date getT_birth() {
        return t_birth;
    }

    public void setT_birth(Date t_birth) {
        this.t_birth = t_birth;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_email() {
        return t_email;
    }

    public void setT_email(String t_email) {
        this.t_email = t_email;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public Integer getResume_id() {
        return resume_id;
    }

    public void setResume_id(Integer resume_id) {
        this.resume_id = resume_id;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_pass='" + t_pass + '\'' +
                ", t_gender='" + t_gender + '\'' +
                ", t_birth=" + t_birth +
                ", t_phone='" + t_phone + '\'' +
                ", t_email='" + t_email + '\'' +
                ", t_address='" + t_address + '\'' +
                ", resume_id=" + resume_id +
                '}';
    }
}
