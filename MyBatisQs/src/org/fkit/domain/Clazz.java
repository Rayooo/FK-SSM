package org.fkit.domain;

import java.util.List;

/**
 * Created by Ray on 2017/3/11.
 */
public class Clazz {
    private Integer id;
    private String code;

    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
