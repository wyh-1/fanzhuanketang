package web.liu.proxy;

import java.util.ArrayList;
import java.util.List;

import web.liu.dao.CourseWareDao;
import web.liu.dao.imp.CourseWareDaoImpl;
import web.liu.db.DBConn;
import web.liu.vo.CourseWare;

public class CourseWareProxy implements CourseWareDao {
	
	private DBConn dbc = null ;
	private CourseWareDao couDao = null;
	
	public CourseWareProxy() throws Exception{
		this.dbc = new DBConn() ;
		this.couDao = new CourseWareDaoImpl(this.dbc.getConnection());
	}

	@Override
	public List findByName(CourseWare courseWare) throws Exception {
		List list = new ArrayList();
		list = this.couDao.findByName(courseWare);
		return list;
	}

	@Override
	public void insertFile(CourseWare courseWare) throws Exception {
		this.couDao.insertFile(courseWare);

	}

	@Override
	public List findPath(CourseWare courseWare) throws Exception {
		List list = new ArrayList();
		list = this.couDao.findPath(courseWare);
		return list;
	}

	@Override
	public List findUserName() throws Exception {
		List list = new ArrayList();
		list = this.couDao.findUserName();
		return list;
	}

}
