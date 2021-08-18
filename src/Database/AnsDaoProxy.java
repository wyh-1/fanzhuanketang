package Database;

import java.util.ArrayList;
import java.util.List;

import com.fanzhuanketang.dao.AnsDao;
import com.fanzhuanketang.po.Ans;

public   class AnsDaoProxy implements AnsDao {
    private DatabaseConnection dbc=null;
    private AnsDao dao=null;
    public AnsDaoProxy() {
        try {
            this.dbc=new DatabaseConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.dao=new AnsDaoImpl(this.dbc.getConnection());
    }

   
    

    @Override
    public boolean saveAns(Ans ans) throws Exception {
        boolean flag=false;
        try{
            flag=this.dao.saveAns(ans);//调用真实主题
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public List<Ans> findByQuesId(int quesID) throws Exception {
        ArrayList<Ans> list=new ArrayList<>();
        try{
            list=(ArrayList<Ans>) this.dao.findByQuesId(quesID);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return list;
    }




}

