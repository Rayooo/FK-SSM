package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Employee;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.EmployeeMapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ray on 2017/3/13.
 */
public class Test {
    public static void main(String[] args){
        SqlSession session = FKSqlSessionFactory.getSqlSession();

        Test test = new Test();
        test.testSelectEmployeeByIdLike(session);

    }

    public void testSelectEmployeeByIdLike(SqlSession session){
        //获得EmployeeMapper接口的代理对象
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        //创建一个HashMap储存参数
        HashMap<String,Object> params = new HashMap<>();

//        params.put("id",1);

        params.put("loginname","jack");
        params.put("password","123456");

        List<Employee> list = em.selectEmployeeByIdLike(params);

        list.forEach(System.out::println);

    }


}
