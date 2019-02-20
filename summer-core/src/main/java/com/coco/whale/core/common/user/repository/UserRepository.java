package com.coco.whale.core.common.user.repository;

import com.coco.whale.core.common.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author like
 * @Data 2019/2/19 16:40
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {


    UserInfo findByName(String name);
}
