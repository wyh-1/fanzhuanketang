package admin.bean;
import java.sql.Timestamp;

//学生行为记录 javabean
public class Student_Monitor {
	private Timestamp createtime;
	private String studentID;
	private String content;
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
