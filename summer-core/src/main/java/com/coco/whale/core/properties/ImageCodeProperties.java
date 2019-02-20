package com.coco.whale.core.properties;

import lombok.Data;

/**
 * @ClassName ImageCodeProperties
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 16:37
 * @Version 1.0
 **/

@Data
public class ImageCodeProperties {

    private int width = 80;
    private int height = 30;
    private int length = 4;
    private int expireIn = 60;
    private int lineCount = 80;
    private String url;
}
