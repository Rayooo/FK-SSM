package org.fkit.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.User;

/**
 * Created by Ray on 2017/3/19.
 */
public interface UserMapper {

    @Select("SELECT * FROM tb_bookuser where loginname = #{loginname} and password = #{password}")
    User findWithLoginNameAndPassword(@Param("loginname") String loginName, @Param("password") String password);


}
