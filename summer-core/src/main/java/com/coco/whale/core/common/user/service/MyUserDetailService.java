package com.coco.whale.core.common.user.service;

import com.coco.whale.core.common.user.entity.UserInfo;
import com.coco.whale.core.common.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyUserDetailService
 * @Description TODO
 * @Author like
 * @Data 2019/2/19 16:39
 * @Version 1.0
 **/
@Component
@Slf4j
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("=============>>userName:{}", userName);
        UserInfo user = userRepository.findByName(userName);
        if (user != null) {
            log.info("=============>>userName:{}", user);
            log.info("=============>>password{}",passwordEncoder.encode(user.getPassword()));
            return new User(userName, passwordEncoder.encode(user.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        }
        return null;
    }
}
