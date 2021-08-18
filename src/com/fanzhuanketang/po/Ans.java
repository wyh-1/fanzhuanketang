package com.fanzhuanketang.po;

import java.sql.Date;

public class Ans {
		private   int quesID;
		private  String text;
		private  Date date;
		private  String TeacherID;

		public void setText(String text){
			this.text = text ;
		}
		
		public void setTime(Date date){
			this.date = date ;
		}
		public void setTeacherID( String TeacherID){
			this.TeacherID= TeacherID;
		}

		public  String getText(){
			
			return text ;
		}
		public  Date getTime(){
			
			return date ;
		}
		public  String getTeacherID(){
			
			return TeacherID ;
		}


	public int getQuesID() {
		return quesID;
	}

	public void setQuesID(int quesID) {
		this.quesID = quesID;
	}
}


