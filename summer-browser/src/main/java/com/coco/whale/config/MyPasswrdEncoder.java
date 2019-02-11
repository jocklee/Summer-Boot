package com.coco.whale.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyBcryptPasswrdEncoder
 * @Description 自定义密码加密解密时，在此处实现
 * @Author like
 * @Data 2019/1/19 16:36
 * @Version 1.0
 **/
//@Component
public class MyPasswrdEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
