package com.coco.whale.config;

import com.coco.whale.handler.WhaleAuthenticationFailureHandler;
import com.coco.whale.handler.WhaleAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import sun.security.util.Password;

/**
 * @ClassName BrowserSecurityConfig
 * @Description web端Security配置类
 * @Author like
 * @Data 2018/12/8 10:40
 * @Version 1.0
 **/
@Configuration
@EnableWebSecurity
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailServiceImpl mUserDetailService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/toLogin")
                //自定义的登录页面请求的url
                .loginProcessingUrl("/user/login")
                .and()
                .authorizeRequests()
                .mvcMatchers("/css/**","/toLogin").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mUserDetailService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
