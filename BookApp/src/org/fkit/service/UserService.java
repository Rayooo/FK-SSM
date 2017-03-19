package org.fkit.service;

import org.fkit.domain.User;

/**
 * Created by Ray on 2017/3/19.
 * User服务层接口
 */
public interface UserService {

    User login(String loginname,String password);

}
