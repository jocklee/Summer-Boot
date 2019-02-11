package com.coco.whale.login.service.Impl;

import com.coco.whale.login.entity.UserInfo;
import com.coco.whale.login.repository.UserRepository;
import com.coco.whale.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author like
 * @Data 2018/12/8 10:11
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserInfo findUserByUsername(String userName) {
        UserInfo user = userRepository.findByUserName(userName);
        return user;
    }
}
