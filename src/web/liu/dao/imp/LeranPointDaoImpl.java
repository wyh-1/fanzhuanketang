package web.liu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.liu.dao.LeranPointDao;
import web.liu.vo.AllFile;
import web.liu.vo.LearnPoint;

public class LeranPointDaoImpl implements LeranPointDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public LeranPointDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List findLeranPoint() throws Exception {
		List<LearnPoint> list = new ArrayList<LearnPoint>();
		try {
			String sql = "select ID from LearnPoint";
			System.out.println(sql);
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();		
			while(rs.next()){
				LearnPoint learnPoint = new LearnPoint();
				learnPoint.setLearnId(rs.getString(1));
				list.add(learnPoint);
			}
			System.out.println("查询知识点成功");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询知识点失败");
		}
		return list;
		
	}

}
