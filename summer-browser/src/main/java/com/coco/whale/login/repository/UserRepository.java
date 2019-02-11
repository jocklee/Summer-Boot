package com.coco.whale.login.repository;

import com.coco.whale.login.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepository
 * @Description 用户dao层
 * @Author like
 * @Data 2018/12/8 10:07
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<UserInfo, String> {

    /**
     * 通过用户名查找用户信息
     * @param userName
     * @return
     */
    UserInfo findByUserName(String userName);


}
