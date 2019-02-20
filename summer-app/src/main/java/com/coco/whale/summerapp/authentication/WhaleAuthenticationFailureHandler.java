package com.coco.whale.summerapp.authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName WhaleAuthenticationFailureHandler
 * @Description TODO
 * @Author like
 * @Data 2019/1/19 14:17
 * @Version 1.0
 **/
@Component("whaleAuthenticationFailureHandler")
public class WhaleAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        //TODO 登录失败 处理逻辑

    }
}
