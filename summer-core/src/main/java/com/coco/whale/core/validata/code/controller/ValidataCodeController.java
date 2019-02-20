package com.coco.whale.core.validata.code.controller;

import com.coco.whale.core.properties.SecurityProperties;
import com.coco.whale.core.utils.ValidateCodeUtil;
import com.coco.whale.core.validata.code.dto.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ValidataCodeController
 * @Description 图片验证码controller
 * @Author like
 * @Data 2019/1/21 17:53
 * @Version 1.0
 **/
@RestController
public class ValidataCodeController {

    @Autowired
    private SecurityProperties securityProperties;

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ImageCode imageCode = createImageCode(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

    private ImageCode createImageCode(ServletWebRequest request) {
        int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height", securityProperties.getCode().getImage().getHeight());
        ValidateCodeUtil vCode = new ValidateCodeUtil(width, height, securityProperties.getCode().getImage().getLength(), securityProperties.getCode().getImage().getLineCount());
        return new ImageCode(vCode.getBuffImg(), vCode.getCode(), securityProperties.getCode().getImage().getExpireIn());
    }
}
