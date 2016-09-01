package com.chainsaw.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by richard on 9/1/16 8:07 PM.
 */
public class Company implements Serializable {
    private static final long serialVersionUID = 2147518643095009850L;
    private String name;
    private String address;
    private String phone;
    private boolean flag;
    private int years;
    private Date create_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
