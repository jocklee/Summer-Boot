package com.coco.whale.user.controller;

import com.coco.whale.core.common.domain.ResponseBean;
import com.coco.whale.core.common.user.entity.UserInfo;
import com.coco.whale.core.common.user.service.UserInfoService;
import com.coco.whale.core.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 9:07
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInfoService userInfoService;


    @PostMapping("/save")
    public ResponseBean saveUser(UserInfo userInfo) {
        Map<String, Object> token = new HashMap<>();
        boolean bo = userInfoService.insertUser(userInfo);
        if (!bo) {
            return ResultUtil.error(-1, "失败", token);
        }
        return ResultUtil.error(200, "成功", token);
    }


}
