package Database;

import java.util.List;

import com.fanzhuanketang.dao.QuesDao;
import com.fanzhuanketang.po.Ques;

public   class QuesDaoProxy implements QuesDao {
    private DatabaseConnection dbc=null;
    private QuesDao dao=null;
    public QuesDaoProxy() {
        try {
            this.dbc=new DatabaseConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.dao=new QuesDaoImpl(this.dbc.getConnection());
    }

   
    

    @Override
    public boolean saveQues(Ques ques) throws Exception {
        boolean flag=false;
        try{
            flag=this.dao.saveQues(ques);//调用真实主题
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }
    public List<Ques> findAll( ) throws Exception{
    	List<Ques> all=null;
    	try{
    		all=this.dao.findAll();
    		}catch(Exception e){
    			throw e;
    		}finally{
    			this.dbc.close();
    		}
    	return all;
    }

    @Override
    public List<Ques> findById(int id) throws Exception {
        List<Ques> all=null;
        try{
            all=this.dao.findById(id);
        }catch(Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return all;
    }

}

