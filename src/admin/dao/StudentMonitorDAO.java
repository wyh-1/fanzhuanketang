package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.Utils.DBUtil;
import admin.bean.Student_Monitor;

public class StudentMonitorDAO {

	public int getPage(String type) throws SQLException {
		int recordCount = 0, t1 = 0, t2 = 0;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection conn = DBUtil.getConnection();
		String sql = null;
		if ("all".equals(type)) {
			sql = "select count(*) from Student_Monitor";
		} else if ("day".equals(type) || "week".equals(type)
				|| "month".equals(type)) {
			sql = "select count(*) from Student_Monitor where DateDiff(" + type
					+ ",CreateTime,getdate())=0";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			result.next();
			recordCount = result.getInt(1);
			t1 = recordCount % 8;
			t2 = recordCount / 8;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseResources(result, pstmt, conn);
		}
		if (t1 != 0) {
			t2 = t2 + 1;
		}
		return t2;
	}

	public List<Student_Monitor> ListMonitor(int pageNo, String type)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Student_Monitor> list = new ArrayList<Student_Monitor>();
		int pageSize = 8;
		int start_page = (pageNo - 1) * pageSize + 1;
		int end_page = pageSize * pageNo;
		Connection conn = DBUtil.getConnection();
		String sql = null;
		if ("all".equals(type)) {
			sql = "select * from (select *,row_number() over (order by StudentID) as rowNum from Student_Monitor) as t "
					+ "where rowNum between " + start_page + " and " + end_page;
		} else if ("day".equals(type) || "week".equals(type)
				|| "month".equals(type)) {
			sql = "select * from (select *,row_number() over (order by StudentID) as rowNum from Student_Monitor where DateDiff(" + type
					+ ",CreateTime,getdate())=0) as t "
					+ "where rowNum between " + start_page + " and " + end_page
					+" and DateDiff(" + type + ",CreateTime,getdate())=0";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			while (result.next()) {
				Student_Monitor sm = new Student_Monitor();
				sm.setCreatetime(result.getTimestamp(1));
				sm.setStudentID(result.getString(2));
				sm.setContent(result.getString(3));
				list.add(sm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseResources(result, pstmt, conn);
		}
		return list;
	}
}
