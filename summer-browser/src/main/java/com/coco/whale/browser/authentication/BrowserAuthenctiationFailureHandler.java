package com.coco.whale.browser.authentication;

import com.coco.whale.core.common.domain.ResponseBean;
import com.coco.whale.core.exception.CustomException;
import com.coco.whale.core.properties.LoginType;
import com.coco.whale.core.properties.SecurityProperties;
import com.coco.whale.core.utils.JacksonJsonUtils;
import com.coco.whale.core.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName BrowserAuthenctiationFailureHandler
 * @Description 自定义失败处理
 * @Author like
 * @Data 2019/2/20 11:49
 * @Version 1.0
 **/
@Slf4j
@Component("browserAuthenctiationFailureHandler")
public class BrowserAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private SecurityProperties securityProperties;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            ResponseBean result = ResultUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), new HashMap<>());
            try {
                response.getWriter().write(JacksonJsonUtils.obj2json(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }


    }
}
