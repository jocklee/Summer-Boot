package com.coco.whale.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author like
 * @Data 2018/12/7 20:01
 * @Version 1.0
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello SummerBoot";
    }
}
