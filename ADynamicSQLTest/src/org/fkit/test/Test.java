package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Employee;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.EmployeeMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Ray on 2017/3/17.
 */
public class Test {
    public static void main(String[] args){
        Test test = new Test();
//        test.testSelectWithParam();
//        test.testInsertEmployee();
//        test.testUpdateEmployee();
        test.testDeleteEmployee();
    }

    public void testSelectWithParam(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        Map<String, Object> param = new HashMap<>();
        param.put("state","ACTIVE");

        List<Employee> list = em.selectWithParam(param);

        list.forEach(System.out::println);

        session.commit();
        session.close();

    }

    public void testInsertEmployee(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setName("Ray");
        employee.setPassword("123");
        employee.setSex("男");

        em.insertEmployee(employee);

        session.commit();
        session.close();

    }

    public void testUpdateEmployee(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        Map<String, Object> param = new HashMap<>();
        param.put("id", 6);

        Employee employee = em.selectEmployeeWithId(param);

        employee.setLoginname("Rayooooo");

        em.updateEmployee(employee);

        session.commit();
        session.close();

    }

    public void testDeleteEmployee(){
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);

        Map<String,Object> param = new HashMap<>();
        param.put("name","ray");
        param.put("loginname","aa");
        em.deleteEmployee(param);

        session.commit();
        session.close();

    }

}
