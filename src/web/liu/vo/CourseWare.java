package web.liu.vo;

public class CourseWare {
	private Integer fileId;
	private String fileTitle;          //文件名
	private String fileDescribe;                 //文件描述
	private String fileWareType;        //文件类型（后缀名）
	private String learnPointID;                 //知识点
	private String filePath;           //文件路径
	private String teacherID;           //教师id
	private String courseID;            //课程ID
	private String createTime;               //创建时间
	private String fileExtName;
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public String getFileDescribe() {
		return fileDescribe;
	}
	public void setFileDescribe(String fileDescribe) {
		this.fileDescribe = fileDescribe;
	}
	public String getFileWareType() {
		return fileWareType;
	}
	public void setFileWareType(String fileWareType) {
		this.fileWareType = fileWareType;
	}
	public String getLearnPointID() {
		return learnPointID;
	}
	public void setLearnPointID(String learnPointID) {
		this.learnPointID = learnPointID;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getFileExtName() {
		return fileExtName;
	}
	public void setFileExtName(String fileExtName) {
		this.fileExtName = fileExtName;
	}
	
	

}
