package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by Ray on 2017/3/11.
 */
public class Test {

    public static void main(String[] args){
//        testInsert();
//        testSelect();
//        testUpdate();
//        testDelete();
        testSelectMap();
    }

    private static void testInsert(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();

        User user = new User("sherry","女",22);

        session.insert("org.fkit.mapper.UserMapper.save",user);

        session.commit();
        session.close();
    }

    private static void testSelect(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        User user = session.selectOne("org.fkit.mapper.UserMapper.selectUser",4);
        System.out.println(user);
        session.commit();
        session.close();
    }

    private static void testUpdate(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        User user = session.selectOne("org.fkit.mapper.UserMapper.selectUser",4);
        user.setName("哈哈哈哈");
        session.update("org.fkit.mapper.UserMapper.modifyUser",user);
        session.commit();
        session.close();
    }

    private static void testDelete(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        session.delete("org.fkit.mapper.UserMapper.removeUser",3);
        session.commit();
        session.close();
    }

    private static void testSelectMap(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        List<Map<String,Object>> list = session.selectList("org.fkit.mapper.UserMapper.selectUserList");

        for (Map<String,Object> row:list){
            System.out.print(row);
        }

        session.commit();
        session.close();

    }

}
