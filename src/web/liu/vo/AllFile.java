package web.liu.vo;

public class AllFile {
	private Integer fileId;     //文件Id
	private String fileName;    //文件名
	private String filePath;	//文件上传路径
	private String fileExtName; //文件后缀名
	private String upDate;      //上传时间
	private String upUserName;  //上传者
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
	public String getFileExtName() {
		return fileExtName;
	}
	public void setFileExtName(String fileExtName) {
		this.fileExtName = fileExtName;
	}
	public String getUpUserName() {
		return upUserName;
	}
	public void setUpUserName(String upUserName) {
		this.upUserName = upUserName;
	}
	
	

}
