package web.liu.factory;

import web.liu.dao.CourseDao;
import web.liu.dao.CourseWareDao;
import web.liu.dao.IAllFileDao;
import web.liu.dao.LeranPointDao;
import web.liu.proxy.AllFileProxy;
import web.liu.proxy.CourseProxy;
import web.liu.proxy.CourseWareProxy;
import web.liu.proxy.LeranPointProxy;

/**
 * 
 * @author Administrator
 * @version 工厂类
 */
public class DAOFactory {
	public static IAllFileDao getIAllFileDAOInstance() throws Exception{
		return new AllFileProxy() ;
	}
	
	public static LeranPointDao getILeranPointDaoInstance() throws Exception{
		return new LeranPointProxy() ;
	}
	
	public static CourseDao getCourseDaoInstance() throws Exception{
		return new CourseProxy() ;
	}
	
	public static CourseWareDao getCourseWareDaoInstance() throws Exception{
		return new CourseWareProxy() ;
	}

}
