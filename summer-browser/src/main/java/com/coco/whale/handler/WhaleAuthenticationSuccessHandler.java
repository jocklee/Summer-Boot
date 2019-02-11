package com.coco.whale.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName WhaleAuthenticationSuccessHandler
 * @Description 登录成功handler
 * @Author like
 * @Data 2019/1/19 14:15
 * @Version 1.0
 **/
@Component("whaleAuthenticationSuccessHandler")
public class WhaleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //TODO 登录成功处理逻辑


    }
}
