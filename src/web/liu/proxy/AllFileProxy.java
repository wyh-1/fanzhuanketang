package web.liu.proxy;

import java.util.ArrayList;
import java.util.List;

import web.liu.dao.IAllFileDao;
import web.liu.dao.imp.IAllFileDaoImpl;
import web.liu.db.DBConn;
import web.liu.vo.AllFile;

public class AllFileProxy implements IAllFileDao {
	private DBConn dbc = null ;
	private IAllFileDao allFileDao = null;
	
	public AllFileProxy() throws Exception{
		this.dbc = new DBConn() ;
		this.allFileDao = new IAllFileDaoImpl(this.dbc.getConnection());
	}

	@Override
	public List findByName(AllFile allFile) throws Exception {
		List list = new ArrayList();
		list = this.allFileDao.findByName(allFile);
		return list;
	}

	@Override
	public void insertFile(AllFile allFile) throws Exception {
		this.allFileDao.insertFile(allFile);

	}

	@Override
	public List findPath(AllFile allFile) throws Exception {
		List list = new ArrayList();
		list = this.allFileDao.findPath(allFile);
		return list;
	}

	@Override
	public List findUserName() throws Exception {
		List list = new ArrayList();
		list = this.allFileDao.findUserName();
		return list;
	}

}
