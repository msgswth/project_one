package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Recruit implements Serializable {
    private Integer rct_id;//招聘ID
    private String com_name;//公司名
    private Integer pos_id;//职位id
    private String rct_intro;//职位描述
    private Date rct_time;//发布的时间
    private String rct_address;//公司的地址
    private Integer rct_salary;//薪资
    private Integer emp_id;//联系人id
    private String rct_is_draft;//判断是否为草稿
    private String rct_is_publish;//是否已经发布

    public Integer getRct_id() {
        return rct_id;
    }

    public void setRct_id(Integer rct_id) {
        this.rct_id = rct_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public Integer getPos_id() {
        return pos_id;
    }

    public void setPos_id(Integer pos_id) {
        this.pos_id = pos_id;
    }

    public String getRct_intro() {
        return rct_intro;
    }

    public void setRct_intro(String rct_intro) {
        this.rct_intro = rct_intro;
    }

    public Date getRct_time() {
        return rct_time;
    }

    public void setRct_time(Date rct_time) {
        this.rct_time = rct_time;
    }

    public String getRct_address() {
        return rct_address;
    }

    public void setRct_address(String rct_address) {
        this.rct_address = rct_address;
    }

    public Integer getRct_salary() {
        return rct_salary;
    }

    public void setRct_salary(Integer rct_salary) {
        this.rct_salary = rct_salary;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getRct_is_draft() {
        return rct_is_draft;
    }

    public void setRct_is_draft(String rct_is_draft) {
        this.rct_is_draft = rct_is_draft;
    }

    public String getRct_is_publish() {
        return rct_is_publish;
    }

    public void setRct_is_publish(String rct_is_publish) {
        this.rct_is_publish = rct_is_publish;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "rct_id=" + rct_id +
                ", com_name='" + com_name + '\'' +
                ", pos_id=" + pos_id +
                ", rct_intro='" + rct_intro + '\'' +
                ", rct_time=" + rct_time +
                ", rct_address='" + rct_address + '\'' +
                ", rct_salary=" + rct_salary +
                ", emp_id=" + emp_id +
                ", rct_is_draft='" + rct_is_draft + '\'' +
                ", rct_is_publish='" + rct_is_publish + '\'' +
                '}';
    }
}
