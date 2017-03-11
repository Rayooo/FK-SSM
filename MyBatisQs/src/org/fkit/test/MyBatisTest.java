package org.fkit.test;


import java.io.InputStream;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fkit.domain.User;


/**
 * Created by Ray on 2017/3/11.
 */
public class MyBatisTest {
    public static void main(String[] args) throws Exception{
        //读取mybatis-config.xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建Session实例
        SqlSession session = sqlSessionFactory.openSession();

        //创建User对象
        User user = new User("admin","1",20);

        //插入数据
        session.insert("org.fkit.mapper.UserMapper.save", user);

        //提交事务
        session.commit();

        //关闭session
        session.close();

    }
}
