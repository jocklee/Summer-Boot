package com.coco.whale.login.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @ClassName User
 * @Description TODO
 * @Author like
 * @Data 2018/12/8 9:55
 * @Version 1.0
 **/
@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String uid;

    private String userName;

    private String passWord;
}
