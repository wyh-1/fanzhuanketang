package com.fanzhuanketang.po;

import java.sql.Date;

public class HomeworkAnswer {
	 private int ID;

	    public int getId() {
	        return ID;
	    }

	    public void setId(int id) {
	        this.ID = id;
	    }
	    private String HomeworkID;
	    private String StudentID;
	    private String SteacherID;
	    private Date CreateTime;
	    public String getStudentID() {
	        return StudentID;
	    }
	    public void setStudentID(String studentID) {
	        this.StudentID = studentID;
	    }
	    public String getHomeworkID() {
	        return HomeworkID;
	    }
	    public void setHomeworkID(String homeworkID) {
	        this.HomeworkID = homeworkID;
	    }
	    public Date getCreateTime() {
	        return CreateTime;
	    }
	    public void setCreateTime(Date createTime) {
	        this.CreateTime = createTime;
	    }
	    public String getSTeacherID() {
	        return SteacherID;
	    }
	    public void setSteacherID(String steacherID) {
	        this.SteacherID = steacherID;
	    }
}
