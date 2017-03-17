package org.fkit.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ray on 2017/3/13.
 */
public class FKSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSessionFactory的静态方法
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    //获取SqlSession对象的方法
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
