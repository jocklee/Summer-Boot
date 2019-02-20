package com.coco.whale.core.common.user.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 14:28
 * @Version 1.0
 **/

@Entity
@ToString
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;
}
