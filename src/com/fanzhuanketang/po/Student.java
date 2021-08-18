package com.fanzhuanketang.po;

import java.sql.Date;

public class Student {
    private String id;
    private String name;
    private boolean sex;
    private Date birthday;
    private String phoneNum;
    private String school;
    private String department;
    private String cls;
    private String password;

    public Student() {
    }

    public Student(String id, String name, boolean sex, Date birthday, String phoneNum, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public Student(String id, String name, boolean sex, Date birthday, String phoneNum, String school, String department, String cls, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNum = phoneNum;
        this.school = school;
        this.department = department;
        this.cls = cls;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getSchool() {
        return school;
    }

    public String getDepartment() {
        return department;
    }

    public String getCls() {
        return cls;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
