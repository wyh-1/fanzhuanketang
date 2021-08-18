package Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;
import javax.swing.JOptionPane;

import com.fanzhuanketang.po.Homework;
public class HomeworkDAO {
	//添加学生作业信息的方法
	public boolean addHomework(String StudentID, java.sql.Date CreateTime, String HomeworkID, String Text){
        DatabaseConnection databaseConnection = null;
		try{
            databaseConnection = new DatabaseConnection();
			Date date = new Date();
			String sql="insert into HomeworkAnswer values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement st=databaseConnection.getConnection().prepareStatement(sql);
			st.setString(1, Text);
			st.setString(2, null);
			st.setString(3, null);
			st.setInt(4, Integer.parseInt(HomeworkID));
			st.setString(5, null);
            st.setObject(6, null);
            st.setObject(7, null);
            st.setString(8, StudentID);
            st.setDate(9, CreateTime);
			int row=st.executeUpdate();
			if(row==1){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			//message("无法添加作业信息，请检查addHomework()方法！");
			return false;
		} finally {
		    if (databaseConnection !=null) databaseConnection.close();
        }
	}
	//查询所有作业任务信息
		public List<Homework> selectHomework(String stuID){
            DatabaseConnection databaseConnection = null;
            ArrayList<Homework> homework = new ArrayList<>();
			try{
                databaseConnection = new DatabaseConnection();
				String sql="select Homework.ID, Homework.Title, Homework.Overtime, Homework.Type, Homework.Text, Homework.CreateTime, Course.Title from Homework, StudentCourse, Course where StudentCourse.StudentID = ? and StudentCourse.CourseID = Homework.CourseID and Course.ID = StudentCourse.CourseID";
                PreparedStatement st=databaseConnection.getConnection().prepareStatement(sql);
                st.setString(1, stuID);
				ResultSet set = st.executeQuery();
				while (set.next()) {
                    Homework homework1 = new Homework();
                    homework1.setId(set.getInt(1));
                    homework1.setTitle(set.getString(2));
                    homework1.setOverTime(set.getDate(3));
                    homework1.setType(set.getString(4));
                    homework1.setText(set.getString(5));
                    homework1.setCreateTime(set.getDate(6));
                    homework1.setCourseTitle(set.getString(7));
                    homework.add(homework1);
                }
			}catch(Exception e){
				e.printStackTrace();
				//message("无法查询作业任务信息，请检查selectHomework()方法！");
				return null;
			} finally {
                if (databaseConnection != null) databaseConnection.close();
            }
            return homework;
		}
				/*
	//一个带参数的信息提示框
	public void message(String msg){
		int type=JOptionPane.YES_NO_OPTION;
		String title="信息提示";
	    JOptionPane.showMessageDialog(null,msg,title,type);
	}
	*/
	}