package com.fanzhuanketang.po;

public class HwAnsComment {
    private String stuID;
    private String createTime;
    private String comment;

    public HwAnsComment() {
    }

    public HwAnsComment(String stuID, String createTime, String comment) {
        this.stuID = stuID;
        this.createTime = createTime;
        this.comment = comment;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
