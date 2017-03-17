package org.fkit.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Student;

import java.util.List;

/**
 * Created by Ray on 2017/3/17.
 */
public interface StudentMapper {

    @Select("SELECT * FROM TB_STUDENT WHERE clazz_id = #{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age",property = "age")
    })
    List<Student> selectByClazzId(Integer id);


}
