package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Person;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.PersonMapper;

/**
 * Created by Ray on 2017/3/12.
 */
public class OneToOneTest {
    public static void main(String[] args){
        SqlSession session = FKSqlSessionFactory.getSqlSession();

        PersonMapper pm = session.getMapper(PersonMapper.class);

        Person p = pm.selectPersonById(1);
        System.out.println(p);
        System.out.print(p.getCard());

        session.commit();
        session.close();
    }

}
