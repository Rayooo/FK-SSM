package org.fkit.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.domain.Clazz;

/**
 * Created by Ray on 2017/3/17.
 */
public interface ClazzMapper {

    @Select("SELECT * FROM TB_CLAZZ WHERE id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "code", property = "code"),
            @Result(column = "name", property = "name"),
            //id作为查询条件，students表示Clazz的students属性
            @Result(column = "id", property = "students", many = @Many(select = "org.fkit.mapper.StudentMapper.selectByClazzId",fetchType = FetchType.LAZY))
    })
    Clazz selectById(Integer id);


}
