package org.fkit.mapper;

import org.fkit.domain.Person;

/**
 * Created by Ray on 2017/3/12.
 */
public interface PersonMapper {

    //根据id查询Person
    //方法名和参数名必须和XML文件中<select ... />中的id和parameterType保持一致
    Person selectPersonById(Integer id);

}
