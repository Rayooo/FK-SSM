package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Clazz;
import org.fkit.domain.Student;
import org.fkit.factory.FKSqlSessionFactory;

import java.util.List;

/**
 * Created by Ray on 2017/3/11.
 */
public class SelectClazzTest {
    public static void main(String[] args){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        List<Clazz> list = session.selectList("selectClazz");

        for (Clazz clazz : list){
            System.out.print(clazz.getCode());

            List<Student> students = clazz.getStudents();
            for(Student s : students){
                System.out.print(s.getName() + " " + s.getSex());
            }
            System.out.println();
        }

        session.commit();
        session.close();

    }
}
