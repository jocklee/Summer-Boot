package com.coco.whale;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BrowserSecurityController
 * @Description TODO
 * @Author like
 * @Data 2018/12/8 15:42
 * @Version 1.0
 **/
@RestController
public class BrowserSecurityController {


    private RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * 当需要身份认证是，跳转到这里
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/authentication/require")
    public String requestAuthentication(HttpServletRequest request, HttpServletResponse response) {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        return null;
    }
}
