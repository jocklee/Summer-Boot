package com.coco.whale.core.properties;

import lombok.Data;

/**
 * @ClassName BrowserProperties
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 10:45
 * @Version 1.0
 **/
@Data
public class BrowserProperties {

    private String loginPage = "/summer-signIn.html";

    private LoginType loginType = LoginType.JSON;

}
