package com.coco.whale.core;

import com.coco.whale.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SecurityCoreConfig
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 10:57
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
