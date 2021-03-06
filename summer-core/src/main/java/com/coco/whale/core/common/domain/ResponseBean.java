package com.coco.whale.core.common.domain;

import lombok.Data;

import java.util.Map;

/**
 * @ClassName ResponseBean
 * @Description 返回json
 * @Author like
 * @Data 2019/2/19 17:01
 * @Version 1.0
 **/
@Data
public class ResponseBean {

    private Integer code;

    private String msg;

    private Object data;

    /**
     * 用于存放token的值，jwtToken
     */
    private Map<String, Object> token;
}
