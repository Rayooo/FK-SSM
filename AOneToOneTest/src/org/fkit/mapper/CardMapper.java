package org.fkit.mapper;

import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Card;

/**
 * Created by Ray on 2017/3/17.
 */
public interface CardMapper {

    @Select("SELECT * FROM tb_card WHERE id = #{id}")
    Card selectCardById(Integer id);

}
