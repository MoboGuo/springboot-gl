package com.example.gladmin.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.common.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/api/login")
public class LoginController {

    /**
     * TODO 登陆验证
     * @return Object
     */
    @PostMapping("/login")
    public Object login(@RequestParam String userName,@RequestParam String password){
        String thisUserName = "lkle";
        String thisPassword = "123456";
        if(thisUserName.equals(userName) && thisPassword.equals(password)) {
            StpUtil.login(10001);
            log.info("登录成功，当前用户:"+thisUserName);
            return RespResult.SUCC("登录成功");
        }
        log.error("登录失败");
        return RespResult.FAIL("登录失败");
    }

    @PostMapping("/isLogin")
    public Object isLogin() {
        return RespResult.SUCC("当前会话是否登录：" + StpUtil.isLogin());
    }

}
