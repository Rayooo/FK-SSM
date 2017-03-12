import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Clazz;
import org.fkit.domain.Student;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.ClazzMapper;

/**
 * Created by Ray on 2017/3/12.
 */
public class OneToManyTest {
    public static void main(String[] args){
        SqlSession session = FKSqlSessionFactory.getSqlSession();

        ClazzMapper cm = session.getMapper(ClazzMapper.class);
        Clazz clazz = cm.selectClazzById(1);
        System.out.println(clazz.getName());

        for(Student student: clazz.getStudents()){
            System.out.println(student.getName());
        }

        session.commit();
        session.close();
    }
}
