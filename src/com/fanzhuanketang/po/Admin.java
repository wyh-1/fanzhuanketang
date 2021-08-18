package com.fanzhuanketang.po;

public class Admin {
    private String account;
    private String name;
    private boolean sex;
    private String place;
    private String phoneNum;
    private String password;

    public Admin() {
    }

    public Admin(String account, String name, boolean sex, String phoneNum, String password) {
        this.account = account;
        this.name = name;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public Admin(String account, String name, boolean sex, String place, String phoneNum, String password) {
        this.account = account;
        this.name = name;
        this.sex = sex;
        this.place = place;
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
