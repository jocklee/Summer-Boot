package com.coco.whale.login.service;

import com.coco.whale.login.entity.UserInfo;

/**
 * @ClassName UserService
 * @Description userService
 * @Author like
 * @Data 2018/12/8 10:10
 * @Version 1.0
 **/

public interface UserService {

    /**
     * 通过用户名查找用户信息
     * @param userName
     * @return
     */
    UserInfo findUserByUsername(String userName);
}
