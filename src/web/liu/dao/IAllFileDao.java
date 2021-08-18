package web.liu.dao;

import java.util.List;

import web.liu.vo.AllFile;



public interface IAllFileDao {
	
	//根据上传者查询
	public List findByName(AllFile allFile)throws Exception;
	
	//上传文件
	public void insertFile(AllFile allFile)throws Exception;
	
	//根据课程名查询
	public List findPath(AllFile allFile)throws Exception;
	
	//查询数据库表所有的上传者姓名
	public List findUserName()throws Exception;

}
