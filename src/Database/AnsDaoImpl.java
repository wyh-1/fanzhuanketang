package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.fanzhuanketang.dao.AnsDao;
import com.fanzhuanketang.po.Ans;

import java.util.ArrayList;
import java.sql.Connection;

public  class AnsDaoImpl implements AnsDao{
	    private Connection con=null;
	    private PreparedStatement ps=null;

	    public AnsDaoImpl(Connection con) {
	        this.con = con;
	    }

		public boolean saveAns(Ans ans) throws Exception {
	        String sql="insert into QuestionAnswer values(?,?,?,?)";
	        try {
	            this.ps=con.prepareStatement(sql);           //根据sql创建PreparedStatement
				this.ps.setInt(1,ans.getQuesID());    	 //设置参数
	            this.ps.setString(2,ans.getTeacherID());        //设置参数
	            this.ps.setDate(3,ans.getTime());  	 //设置参数
	            this.ps.setString(4, ans.getText());
	            return this.ps.executeUpdate() > 0;                     //执行插入
	        }catch (Exception e) {
	            throw e;
	        }finally{
	            if(this.ps!=null){
	                try{
	                    this.ps.close();
	                }catch (Exception e){
	                    throw e;
	                }
	            }
	        }
	    }

	@Override
	public List<Ans> findByQuesId(int quesID) throws Exception {
		ArrayList<Ans> list=new ArrayList<>();
		String sql="select * from QuestionAnswer where QuestionID=? order by CreateTime asc";   //定义查询数据库的SQL语句

		try {
			ps=con.prepareStatement(sql);           //根据sql创建PreparedStatement
			ps.setInt(1, quesID);
			ResultSet rs;
			rs=ps.executeQuery();
			while (rs.next()) {
				Ans ans=new Ans();
				ans.setQuesID(quesID);
				ans.setText(rs.getString(4));
				ans.setTime(rs.getDate(3));
				ans.setTeacherID(rs.getString(2));
				list.add(ans);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		} finally {
			if(this.ps!=null){
				try{
					this.ps.close();
				}catch (Exception e){
					throw e;
				}
			}
		}
		return list;
	}
			
			
		
	}