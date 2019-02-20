package com.coco.whale.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SecurityProperties
 * @Description 配置文件
 * @Author like
 * @Data 2019/2/20 10:45
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "summer.security")
@Data
public class SecurityProperties {
    BrowserProperties browser = new BrowserProperties();
    private ValidateCodeProperties code = new ValidateCodeProperties();
}
