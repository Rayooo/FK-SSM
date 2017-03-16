package org.fkit.mapper;

import org.fkit.domain.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ray on 2017/3/13.
 */
public interface EmployeeMapper {
    List<Employee> selectEmployeeByIdLike(HashMap<String,Object> params);

    List<Employee> selectEmployeeChoose(HashMap<String,Object> params);

}
