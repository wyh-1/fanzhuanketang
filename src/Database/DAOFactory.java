package Database;

import com.fanzhuanketang.dao.AnsDao;
import com.fanzhuanketang.dao.CourseDao;
import com.fanzhuanketang.dao.QuesDao;

public class DAOFactory {
    public static final int DEFAULT = 0;

    public static QuesDao getQuesDaoInstance() throws Exception{
        return new QuesDaoProxy();    }

    public static AnsDao getAnsDaoInstance() throws Exception{
        return new AnsDaoProxy();    }

    public static CourseDao getCourseDAOInstance(){
        return new CourseDaoImpl();
    }
}
