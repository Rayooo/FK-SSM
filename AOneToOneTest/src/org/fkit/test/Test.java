package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Clazz;
import org.fkit.domain.Person;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.ClazzMapper;
import org.fkit.mapper.PersonMapper;

/**
 * Created by Ray on 2017/3/17.
 */
public class Test {
    public static void main(String[] args){
        Test test = new Test();

        test.testOneToMany();

    }

    public void testOneToOne(){

        SqlSession session = FKSqlSessionFactory.getSqlSession();
        PersonMapper pm = session.getMapper(PersonMapper.class);

        Person person = pm.selectPersonById(1);

        System.out.println(person);
        System.out.println(person.getCard());

        session.commit();
        session.close();

    }

    public void testOneToMany(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        ClazzMapper cm = session.getMapper(ClazzMapper.class);

        Clazz clazz = cm.selectById(1);

        System.out.println(clazz);

        clazz.getStudents().forEach(System.out::println);

        session.commit();
        session.close();
    }

}
