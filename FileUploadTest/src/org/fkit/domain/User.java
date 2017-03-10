package org.fkit.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by Ray on 2017/3/10.
 */
public class User implements Serializable {

    private String username;

    //对应上传的file，类型为MultipartFile，上传文件会自动绑定到image属性中
    private MultipartFile image;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
