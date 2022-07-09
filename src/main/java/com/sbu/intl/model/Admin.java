package com.sbu.intl.model;

import com.sbu.intl.model.User;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Admin extends User {
    private String position;
    private String mobileNum;

    public Admin(String email, String password, String position, String mobileNum) {
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

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}
