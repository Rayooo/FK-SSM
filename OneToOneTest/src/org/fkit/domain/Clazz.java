package org.fkit.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ray on 2017/3/12.
 */
public class Clazz implements Serializable {

    private Integer id;
    private String code;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
