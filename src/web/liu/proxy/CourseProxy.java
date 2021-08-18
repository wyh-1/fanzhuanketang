package web.liu.proxy;

import java.util.ArrayList;
import java.util.List;

import web.liu.dao.CourseDao;
import web.liu.dao.imp.CourseDaoImpl;
import web.liu.db.DBConn;

public class CourseProxy implements CourseDao {

	private DBConn dbc = null ;
	private CourseDao courseDao = null;
	
	public CourseProxy() throws Exception{
		this.dbc = new DBConn() ;
		this.courseDao = new CourseDaoImpl(this.dbc.getConnection());
	}
	
	@Override
	public List findTitle() throws Exception {
		List list = new ArrayList();
		list = this.courseDao.findTitle();
		return list;
	}

}
