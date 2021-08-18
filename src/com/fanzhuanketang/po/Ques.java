package com.fanzhuanketang.po;

import java.sql.Date;

public class Ques {
	private int id;
		private  String title;
		private  String type;
		private  String text;
		private  Date date;
		private  String StudentID;
		

		
		public void setType(String type){
			this.type= type ;
		}
		public void setText(String text){
			this.text = text ;
		}
		public void setTitle(String title){
			this.title = title ;
		}
		public void setTime(Date date) {
			this.date=date;
		}
		
		public void setStudentID(String StudentID){
			this.StudentID= StudentID;
		}
		
		
		public  String getType(){
			
			return type;
		}
		public  String getTitle() {
			return title;
		}
		
		public  String getText(){
			
			return text ;
		}
		public Date getTime(){
			return date;
		}
		
		public  String getStudentID(){
			
			return StudentID ;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}


