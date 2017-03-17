package org.fkit.mapper;

import org.apache.ibatis.annotations.*;
import org.fkit.domain.User;

import java.util.List;

/**
 * Created by Ray on 2017/3/17.
 */
public interface UserMapper {

    @Insert("INSERT INTO tb_user(name,sex,age) VALUES(#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveUser(User user);


    @Delete("DELETE FROM tb_user WHERE id = #{id}")
    int removeUser(@Param("id") Integer id);


    @Update("UPDATE tb_user SET name = #{name}, sex = #{sex}, age = #{age} WHERE id = #{id}")
    void modifyUser(User user);


    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    //列和属性之间的映射
    @Results({
            @Result(id=true,column = "id", property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age")
    })
    User selectUserById(Integer id);


    @Select("SELECT * FROM tb_user")
    List<User> selectAllUser();
}
