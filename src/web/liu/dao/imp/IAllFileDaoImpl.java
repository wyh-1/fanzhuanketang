package web.liu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.liu.dao.IAllFileDao;
import web.liu.vo.AllFile;

public class IAllFileDaoImpl implements IAllFileDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IAllFileDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List findByName(AllFile allFile) throws Exception {
		List<AllFile> list = new ArrayList<AllFile>();
		String upUserName = allFile.getUpUserName();
		try {
			String sql = "select * from AllFile where UP_USER_NAME like ?  order by FILE_EXT_NAME asc";
			this.pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + upUserName + "%");// 自动添加单引号
																// （包装后的参数）
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				AllFile af = new AllFile();
				af.setFilePath(rs.getString(3));
				af.setFileExtName(rs.getString(4));
				af.setUpUserName(rs.getString(6));
				list.add(af);
			}
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return list;
	}

	@Override
	public void insertFile(AllFile allFile) throws Exception {
		try {
			String sql = "insert into AllFile values(?,?,?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, allFile.getFileName());
			pstmt.setString(2, allFile.getFilePath());
			pstmt.setString(3, allFile.getFileExtName());
			pstmt.setString(4, allFile.getUpDate());
			pstmt.setString(5, allFile.getUpUserName());
			int num = this.pstmt.executeUpdate();
			if(num > 0){
				System.out.println(sql);
				System.out.println("上传成功");
			}

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("上传失败");
		}
	}

	@Override
	public List findPath(AllFile af) throws Exception {
		List<AllFile> list = new ArrayList<AllFile>();
		try {
			String sql = "select DISTINCT FILE_PATH,FILE_EXT_NAME from AllFile where FILE_EXT_NAME like ? order by FILE_PATH";
			System.out.println(sql);
			this.pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + af.getFileExtName() + "%");// 自动添加单引号
			ResultSet rs = this.pstmt.executeQuery();		
			while(rs.next()){
				AllFile allFile = new AllFile();
				allFile.setFilePath(rs.getString(1));
				allFile.setFileExtName(rs.getString(2));
				list.add(allFile);
			}
			System.out.println("查询成功");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询失败");
		}
		return list;
	}

	@Override
	public List findUserName() throws Exception {
		List<AllFile> list = new ArrayList<AllFile>();
		try {
			String sql = "select DISTINCT UP_USER_NAME from AllFile";
			System.out.println(sql);
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();		
			while(rs.next()){
				AllFile allFile = new AllFile();
				allFile.setUpUserName(rs.getString(1));
				list.add(allFile);
			}
			System.out.println("查询上传者成功");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询上传者失败");
		}
		return list;
	}

}
