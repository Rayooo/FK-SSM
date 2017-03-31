package org.fkit.mapper;

import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Book;

import java.util.List;

/**
 * Created by Ray on 2017/3/19.
 */
public interface BookMapper {

    @Select("SELECT * FROM tb_book")
    List<Book> findAll();

}
