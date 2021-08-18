package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.fanzhuanketang.dao.QuesDao;
import com.fanzhuanketang.po.Ques;

import java.util.ArrayList;
import java.sql.Connection;

public  class QuesDaoImpl implements QuesDao{
	    private Connection con=null;
	    private PreparedStatement ps=null;

	    public QuesDaoImpl(Connection con) {
	        this.con = con;
	    }
	    
	  
	   
	    
	     
		@Override
	    public boolean saveQues(Ques ques) throws Exception {
	        String sql="insert into Question values(?,?,?,?,?) ";
	        try {
	            this.ps=con.prepareStatement(sql);       //根据sql创建PreparedStatement
		        this.ps.setString(1, ques.getTitle());   //设置参数
	            this.ps.setString(2, ques.getText());  	//设置参数
	            this.ps.setString(3, ques.getType()); //设置参数
	            this.ps.setDate(4, ques.getTime());
	            this.ps.setString(5, ques.getStudentID());	//设置参数
	            this.ps.executeUpdate();                     //执行插入
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
	        return true;
	    }
		





		@Override
		public List<Ques> findAll() throws Exception {
			ArrayList<Ques> list=new ArrayList<>();
	        String sql="select * from Question order by ID asc";   //定义查询数据库的SQL语句

	        try {
	            ps=con.prepareStatement(sql);           //根据sql创建PreparedStatement
	            ResultSet rs;
	            rs=ps.executeQuery();
	            while (rs.next()) {
	                Ques ques=new Ques();
	                ques.setId(rs.getInt(1));
	                ques.setTitle(rs.getString(2));
					ques.setType(rs.getString(4));
					ques.setText(rs.getString(3));
					ques.setTime(rs.getDate(5));
					ques.setStudentID(rs.getString(6));	
	                list.add(ques);
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

	@Override
	public List<Ques> findById(int id) throws Exception {
		ArrayList<Ques> list=new ArrayList<>();
		String sql="select * from Question where ID=?";   //定义查询数据库的SQL语句

		try {
			ps=con.prepareStatement(sql);           //根据sql创建PreparedStatement
			ps.setInt(1, id);
			ResultSet rs;
			rs=ps.executeQuery();
			while (rs.next()) {
				Ques ques=new Ques();
				ques.setId(id);
				ques.setTitle(rs.getString(2));
				ques.setType(rs.getString(4));
				ques.setText(rs.getString(3));
				ques.setTime(rs.getDate(5));
				ques.setStudentID(rs.getString(6));
				list.add(ques);
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





		

			
			
			
		