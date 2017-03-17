package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;

import java.util.List;

/**
 * Created by Ray on 2017/3/17.
 */
public class Test {

    public static void main(String[] args){
        Test test = new Test();

//        test.insertTest();
//        test.selectTest();
//        test.updateTest();
//        test.deleteTest();
        test.selectAllTest();
    }

    public void insertTest(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();

        UserMapper um = session.getMapper(UserMapper.class);

        User user = new User();
        user.setName("test");
        user.setAge(20);
        user.setSex("男");

        um.saveUser(user);

        System.out.println(user.getId());

        session.commit();
        session.close();

    }

    public void selectTest(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        UserMapper um = session.getMapper(UserMapper.class);

        User user = um.selectUserById(4);

        System.out.println(user);

        session.commit();
        session.close();

    }

    public void updateTest(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        UserMapper um = session.getMapper(UserMapper.class);

        User user = um.selectUserById(4);
        System.out.println(user);

        user.setName("嘿嘿嘿");
        user.setSex("男");

        um.modifyUser(user);

        session.commit();
        session.close();

    }

    public void deleteTest(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        UserMapper um = session.getMapper(UserMapper.class);

        um.removeUser(8);

        session.commit();
        session.close();

    }

    public void selectAllTest(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        UserMapper um = session.getMapper(UserMapper.class);

        List<User> list = um.selectAllUser();

        list.forEach(System.out::println);

        session.commit();
        session.close();

    }

}
