package org.fkit.domain;

import java.io.Serializable;

/**
 * Created by Ray on 2017/3/12.
 */
public class Card implements Serializable {
    private Integer id;
    private String code;

    public String getCode() {
        return code;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
