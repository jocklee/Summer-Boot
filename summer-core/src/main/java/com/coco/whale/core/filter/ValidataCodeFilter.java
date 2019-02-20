package com.coco.whale.core.filter;

import com.coco.whale.core.exception.ValidataCodeException;
import com.coco.whale.core.properties.SecurityProperties;
import com.coco.whale.core.validata.code.controller.ValidataCodeController;
import com.coco.whale.core.validata.code.dto.ImageCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ValidateCodeFilter
 * @Description 图形验证码过滤器
 * @Author like
 * @Data 2019/2/20 15:09
 * @Version 1.0
 **/
@Data
public class ValidataCodeFilter extends OncePerRequestFilter implements InitializingBean {

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private Set<String> urls = new HashSet<>();

    private SecurityProperties securityProperties;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String [] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(),",");
        for(String configUrl:configUrls){
            urls.add(configUrl);
        }
        urls.add("/summer/authentication/form");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        boolean action = false;
        for(String url : urls){
            if(pathMatcher.match(url,request.getRequestURI())){
                action = true;
            }
        }


//        if (StringUtils.equals("/summer/authentication/form", request.getRequestURI())
//                && StringUtils.equalsAnyIgnoreCase(request.getMethod(), "post")) {
        if(action){
            try {
                validata(new ServletWebRequest(request));
            } catch (ValidataCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }

        }
        filterChain.doFilter(request, response);
    }

    private void validata(ServletWebRequest request) throws ServletRequestBindingException {
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidataCodeController.SESSION_KEY);
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidataCodeException("验证码不能为空");
        }
        if (codeInSession == null) {
            throw new ValidataCodeException("验证码不存在");
        }
        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(request, ValidataCodeController.SESSION_KEY);
            throw new ValidataCodeException("验证码已过期");
        }
        if (!StringUtils.equalsAnyIgnoreCase(codeInSession.getCode(), codeInRequest)) {
            throw new ValidataCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(request, ValidataCodeController.SESSION_KEY);
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public SessionStrategy getSessionStrategy() {
        return sessionStrategy;
    }

    public void setSessionStrategy(SessionStrategy sessionStrategy) {
        this.sessionStrategy = sessionStrategy;
    }
}
