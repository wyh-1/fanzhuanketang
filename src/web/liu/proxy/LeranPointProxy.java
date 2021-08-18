package web.liu.proxy;

import java.util.ArrayList;
import java.util.List;

import web.liu.dao.LeranPointDao;
import web.liu.dao.imp.LeranPointDaoImpl;
import web.liu.db.DBConn;

public class LeranPointProxy implements LeranPointDao{
	private DBConn dbc = null ;
	private LeranPointDao lpd = null;
	
	public LeranPointProxy() throws Exception{
		this.dbc = new DBConn() ;
		this.lpd = new LeranPointDaoImpl(this.dbc.getConnection());
	}
	
	
	public List findLeranPoint() throws Exception{
		List list = new ArrayList();
		list = this.lpd.findLeranPoint();
		return list;
	}
	

}
