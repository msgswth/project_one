package com.iotek.model;

import java.io.Serializable;
import java.sql.Date;

public class Interview implements Serializable {
    private Integer v_id;
    private Integer rs_id;
    private Integer rct_id;
    private Date v_date;
    private String v_is_read;
    private String v_is_accept;//接受代表录用此人
    private String v_is_agree;//同意代表参加面试

    public Integer getV_id() {
        return v_id;
    }

    public void setV_id(Integer v_id) {
        this.v_id = v_id;
    }

    public Integer getRs_id() {
        return rs_id;
    }

    public void setRs_id(Integer rs_id) {
        this.rs_id = rs_id;
    }

    public Integer getRct_id() {
        return rct_id;
    }

    public void setRct_id(Integer rct_id) {
        this.rct_id = rct_id;
    }

    public Date getV_date() {
        return v_date;
    }

    public void setV_date(Date v_date) {
        this.v_date = v_date;
    }

    public String getV_is_read() {
        return v_is_read;
    }

    public void setV_is_read(String v_is_read) {
        this.v_is_read = v_is_read;
    }

    public String getV_is_accept() {
        return v_is_accept;
    }

    public void setV_is_accept(String v_is_accept) {
        this.v_is_accept = v_is_accept;
    }

    public String getV_is_agree() {
        return v_is_agree;
    }

    public void setV_is_agree(String v_is_agree) {
        this.v_is_agree = v_is_agree;
    }

    @Override
    public String toString() {
        return "InterviewDao{" +
                "v_id=" + v_id +
                ", rs_id=" + rs_id +
                ", rct_id=" + rct_id +
                ", v_date=" + v_date +
                ", v_is_read='" + v_is_read + '\'' +
                ", v_is_accept='" + v_is_accept + '\'' +
                ", v_is_agree='" + v_is_agree + '\'' +
                '}';
    }
}
