package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Student;
import org.fkit.factory.FKSqlSessionFactory;

import java.util.List;

/**
 * Created by Ray on 2017/3/11.
 */
public class SelectStudentTest {
    public static void main(String[] args){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        List<Student> list = session.selectList("org.fkit.mapper.UserMapper.selectStudent");

        for(Student s : list){
            System.out.println(s);
        }
    }
}
