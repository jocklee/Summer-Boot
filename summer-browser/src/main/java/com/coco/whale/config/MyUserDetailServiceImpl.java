package com.coco.whale.config;

import com.coco.whale.login.entity.UserInfo;
import com.coco.whale.login.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName MyUserDetailServiceImpl
 * @Description TODO
 * @Author like
 * @Data 2018/12/8 13:56
 * @Version 1.0
 **/
@Service
@Slf4j
//@Component
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 根据用户名查找用户信息
        // 2. 根据查找到的用户信息，判断用户是否冻结
        UserInfo userInfo = userRepository.findByUserName(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        log.info("======>登录用户名：{}", userInfo.getUserName());
        return new User(userInfo.getUserName(), new BCryptPasswordEncoder().encode(userInfo.getPassWord()),
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
