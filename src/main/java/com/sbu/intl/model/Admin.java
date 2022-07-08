package com.sbu.intl.model;

import com.sbu.intl.model.User;

public class Admin extends User {
    private String position;
    private long mobileNum;

    public Admin(String email, String password, String position, long mobileNum) {
        super(email, password);
        this.position = position;
        this.mobileNum = mobileNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(long mobileNum) {
        this.mobileNum = mobileNum;
    }
}
