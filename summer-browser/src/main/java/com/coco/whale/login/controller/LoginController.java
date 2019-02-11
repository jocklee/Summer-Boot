package com.coco.whale.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author like
 * @Data 2019/1/19 17:26
 * @Version 1.0
 **/
@Controller
public class LoginController {

    @GetMapping("/toLogin")
    public String toLogin() {
        return "singin";
    }
}
