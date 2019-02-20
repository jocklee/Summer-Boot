package com.coco.whale.core.common.user.service.impl;

import com.coco.whale.core.common.user.entity.UserInfo;
import com.coco.whale.core.common.user.repository.UserRepository;
import com.coco.whale.core.common.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author like
 * @Data 2019/2/19 16:59
 * @Version 1.0
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    UserRepository userRepository;

    @Override
    public boolean insertUser(UserInfo userInfo) {
        UserInfo flag = userRepository.save(userInfo);
        if (flag != null) {
            return true;
        }
        return true;
    }
}
