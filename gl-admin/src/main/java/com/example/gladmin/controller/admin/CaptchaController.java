package com.example.gladmin.controller.admin;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api("验证码")
@Slf4j
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @GetMapping("/captchaImage")
    public void generate(HttpServletRequest request, HttpServletResponse response){
        GifCaptcha gifCaptcha = new GifCaptcha(130,48,5);
        try {
            CaptchaUtil.out(gifCaptcha, request, response);
        } catch (IOException e) {
            log.error("返回验证码出错！错误信息:{}", e.getMessage());
        }
    }
}
