package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {
    private Integer emp_id;
    private String emp_name;
    private String emp_pass;
    private Integer emp_type;
    private String emp_gender;
    private String emp_address;
    private String emp_phone;
    private String emp_bank_card;
    private Date emp_hiredate;
    private Integer emp_salary;
    private String emp_state;
    private Integer emp_dep_id;
    private Integer emp_pos_id;
    private Integer emp_idcard;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public Integer getEmp_type() {
        return emp_type;
    }

    public void setEmp_type(Integer emp_type) {
        this.emp_type = emp_type;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmp_bank_card() {
        return emp_bank_card;
    }

    public void setEmp_bank_card(String emp_bank_card) {
        this.emp_bank_card = emp_bank_card;
    }

    public Date getEmp_hiredate() {
        return emp_hiredate;
    }

    public void setEmp_hiredate(Date emp_hiredate) {
        this.emp_hiredate = emp_hiredate;
    }

    public Integer getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(Integer emp_salary) {
        this.emp_salary = emp_salary;
    }

    public String getEmp_state() {
        return emp_state;
    }

    public void setEmp_state(String emp_state) {
        this.emp_state = emp_state;
    }

    public Integer getEmp_dep_id() {
        return emp_dep_id;
    }

    public void setEmp_dep_id(Integer emp_dep_id) {
        this.emp_dep_id = emp_dep_id;
    }

    public Integer getEmp_pos_id() {
        return emp_pos_id;
    }

    public void setEmp_pos_id(Integer emp_pos_id) {
        this.emp_pos_id = emp_pos_id;
    }

    public Integer getEmp_idcard() {
        return emp_idcard;
    }

    public void setEmp_idcard(Integer emp_idcard) {
        this.emp_idcard = emp_idcard;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_pass='" + emp_pass + '\'' +
                ", emp_type=" + emp_type +
                ", emp_gender='" + emp_gender + '\'' +
                ", emp_address='" + emp_address + '\'' +
                ", emp_phone='" + emp_phone + '\'' +
                ", emp_bank_card='" + emp_bank_card + '\'' +
                ", emp_hiredate=" + emp_hiredate +
                ", emp_salary=" + emp_salary +
                ", emp_state='" + emp_state + '\'' +
                ", emp_dep_id=" + emp_dep_id +
                ", emp_pos_id=" + emp_pos_id +
                ", emp_idcard=" + emp_idcard +
                '}';
    }
}
