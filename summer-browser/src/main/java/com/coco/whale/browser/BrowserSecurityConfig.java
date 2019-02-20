package com.coco.whale.browser;

import com.coco.whale.core.filter.ValidataCodeFilter;
import com.coco.whale.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @ClassName BrowserSecurityConfig
 * @Description 浏览器security配置
 * @Author like
 * @Data 2019/2/19 16:22
 * @Version 1.0
 **/
@Configuration
@EnableWebSecurity
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler browserAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler browserAuthenctiationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository PersistentTokenReepository(){
        JdbcTokenRepositoryImpl tokenRepository= new JdbcTokenRepositoryImpl();
        return null;//TODO
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidataCodeFilter validataCodeFilter = new ValidataCodeFilter();
        validataCodeFilter.setAuthenticationFailureHandler(browserAuthenctiationFailureHandler);
        validataCodeFilter.setSecurityProperties(securityProperties);
        validataCodeFilter.afterPropertiesSet();
        http.addFilterBefore(validataCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(browserAuthenticationSuccessHandler)
                .failureHandler(browserAuthenctiationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/code/image", "/authentication/require", securityProperties.getBrowser().getLoginPage(), "/user/save").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();

    }
}
