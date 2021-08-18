package com.fanzhuanketang.po;

import java.sql.Date;

public class Homework {
    private int ID;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID= id;
    }

    private String title;
    private Date overTime;
    private String Type;
    private String Text;
    private Date CreateTime;
    private String CourseID;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        this.CreateTime = createTime;
    }

    public String getCourseTitle() {
        return CourseID;
    }

    public void setCourseTitle(String courseTitle) {
        this.CourseID = courseTitle;
    }
}
