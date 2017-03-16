package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Employee;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.EmployeeMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ray on 2017/3/13.
 */
public class Test {
    public static void main(String[] args){
        SqlSession session = FKSqlSessionFactory.getSqlSession();

        Test test = new Test();
//        test.testSelectEmployeeByIdLike(session);

//        test.testSelectEmployeeChoose();

//        test.testSelectEmployeeLike();

//        test.testUpdateEmployeeIfNecessary();
//        test.testSelectEmployeeIn();
        test.testSelectEmployeeLikeName();
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

        session.commit();
        session.close();
    }

    public void testSelectEmployeeChoose(){

        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        HashMap<String,Object> params = new HashMap<>();
//        params.put("id",1);
//        params.put("loginname","jack");
//        params.put("password","123456");

        List<Employee> list = em.selectEmployeeChoose(params);
        list.forEach(employee -> System.out.println(employee.getName()));

        session.commit();
        session.close();
    }

    public void testSelectEmployeeLike(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        HashMap<String,Object> params = new HashMap<>();

        params.put("id",1);
        params.put("loginname","jack");
        params.put("password","123456");

        List<Employee> list = em.selectEmployeeLike(params);

        list.forEach(employee -> System.out.println(employee.getName()));

        session.commit();
        session.close();
    }

    public void testUpdateEmployeeIfNecessary(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        Employee employee = em.selectEmployeeById(4);

        employee.setLoginname("mary");
        employee.setPassword("123");
        employee.setName("玛丽");

        em.updateEmployeeIfNecessary(employee);

        session.commit();
        session.close();
    }

    public void testSelectEmployeeIn(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<Employee> list = em.selectEmployeeIn(ids);
        list.forEach(employee -> System.out.println(employee.getName()));

        session.commit();
        session.close();

    }

    public void testSelectEmployeeLikeName(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setName("o");

        List<Employee> list = em.selectEmployeeLikeName(employee);

        list.forEach(e -> {System.out.println(e.getLoginname());});

        session.commit();
        session.close();

    }

}
