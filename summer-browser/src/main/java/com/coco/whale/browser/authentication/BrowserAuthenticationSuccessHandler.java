package com.coco.whale.browser.authentication;

import com.coco.whale.core.common.domain.ResponseBean;
import com.coco.whale.core.properties.LoginType;
import com.coco.whale.core.properties.SecurityProperties;
import com.coco.whale.core.utils.JacksonJsonUtils;
import com.coco.whale.core.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName BrowserAuthenticationSuccessHandler
 * @Description 自定义成功处理
 * @Author like
 * @Data 2019/2/20 11:49
 * @Version 1.0
 **/
@Slf4j
@Component("browserAuthenticationSuccessHandler")
public class BrowserAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            ResponseBean responseBean = ResultUtil.success("登录成功",authentication.getPrincipal(),new HashMap<>());
            try {
                response.getWriter().write(JacksonJsonUtils.obj2json(responseBean));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }


    }
}
