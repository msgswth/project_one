package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Resume implements Serializable {
    private Integer rs_id;//简历id
    private Integer t_id;//游客id
    private String rs_name;//姓名
    private String rs_gender;//性别
    private Date rs_birth;//出生日期
    private String rs_address;//住址
    private String rs_school;//毕业院校
    private String rs_education;//学历
    private String rs_major;//专业
    private Date rs_enroll_date;//入学时间
    private Date rs_graduation_date;//毕业时间
    private Integer rs_salary;//期望薪资
    private String rs_exprience;//学习和实习经历

    public Integer getRs_id() {
        return rs_id;
    }

    public void setRs_id(Integer rs_id) {
        this.rs_id = rs_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getRs_name() {
        return rs_name;
    }

    public void setRs_name(String rs_name) {
        this.rs_name = rs_name;
    }

    public String getRs_gender() {
        return rs_gender;
    }

    public void setRs_gender(String rs_gender) {
        this.rs_gender = rs_gender;
    }

    public Date getRs_birth() {
        return rs_birth;
    }

    public void setRs_birth(Date rs_birth) {
        this.rs_birth = rs_birth;
    }

    public String getRs_address() {
        return rs_address;
    }

    public void setRs_address(String rs_address) {
        this.rs_address = rs_address;
    }

    public String getRs_school() {
        return rs_school;
    }

    public void setRs_school(String rs_school) {
        this.rs_school = rs_school;
    }

    public String getRs_education() {
        return rs_education;
    }

    public void setRs_education(String rs_education) {
        this.rs_education = rs_education;
    }

    public String getRs_major() {
        return rs_major;
    }

    public void setRs_major(String rs_major) {
        this.rs_major = rs_major;
    }

    public Date getRs_enroll_date() {
        return rs_enroll_date;
    }

    public void setRs_enroll_date(Date rs_enroll_date) {
        this.rs_enroll_date = rs_enroll_date;
    }

    public Date getRs_graduation_date() {
        return rs_graduation_date;
    }

    public void setRs_graduation_date(Date rs_graduation_date) {
        this.rs_graduation_date = rs_graduation_date;
    }

    public Integer getRs_salary() {
        return rs_salary;
    }

    public void setRs_salary(Integer rs_salary) {
        this.rs_salary = rs_salary;
    }

    public String getRs_exprience() {
        return rs_exprience;
    }

    public void setRs_exprience(String rs_exprience) {
        this.rs_exprience = rs_exprience;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "rs_id=" + rs_id +
                ", t_id=" + t_id +
                ", rs_name='" + rs_name + '\'' +
                ", rs_gender='" + rs_gender + '\'' +
                ", rs_birth=" + rs_birth +
                ", rs_address='" + rs_address + '\'' +
                ", rs_school='" + rs_school + '\'' +
                ", rs_education='" + rs_education + '\'' +
                ", rs_major='" + rs_major + '\'' +
                ", rs_enroll_date=" + rs_enroll_date +
                ", rs_graduation_date=" + rs_graduation_date +
                ", rs_salary=" + rs_salary +
                ", rs_exprience='" + rs_exprience + '\'' +
                '}';
    }
}
