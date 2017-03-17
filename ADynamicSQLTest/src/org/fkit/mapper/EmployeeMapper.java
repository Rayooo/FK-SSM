package org.fkit.mapper;

import org.apache.ibatis.annotations.*;
import org.fkit.domain.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by Ray on 2017/3/17.
 */
public interface EmployeeMapper {

    //查询
    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "selectWithParam")
    List<Employee> selectWithParam(Map<String, Object> param);

    //插入
    @InsertProvider(type = EmployeeDynaSqlProvider.class, method = "insertEmployee")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertEmployee(Employee employee);

    //根据id查询
    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "selectWithParam")
    Employee selectEmployeeWithId(Map<String,Object> param);
    //动态更新
    @UpdateProvider(type = EmployeeDynaSqlProvider.class, method = "updateEmployee")
    void updateEmployee(Employee employee);

    //删除
    @DeleteProvider(type = EmployeeDynaSqlProvider.class, method = "deleteEmployee")
    void deleteEmployee(Map<String, Object> param);


}
