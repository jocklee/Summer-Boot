package com.coco.whale.core.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName ValidateCodeException
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 15:13
 * @Version 1.0
 **/

public class ValidataCodeException extends AuthenticationException {

    public ValidataCodeException(String msg) {
        super(msg);
    }
}
