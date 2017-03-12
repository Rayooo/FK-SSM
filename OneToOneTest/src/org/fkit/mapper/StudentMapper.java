package org.fkit.mapper;

import org.fkit.domain.Student;

/**
 * Created by Ray on 2017/3/12.
 */
public interface StudentMapper {
    Student selectStudentById(Integer id);
}
