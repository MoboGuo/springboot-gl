package com.example.gladmin.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    /**
     * TODO 登陆验证
     * @return Object
     */
    @PostMapping("/login")
    public Object login(@RequestParam String userName,@RequestParam String password){
        Map<Object, Object> map = new HashMap<>();
        if("lkle".equals(userName) && "123456".equals(password)) {
            StpUtil.login(10001);
            map.put("msg","登录成功");
            return map;
        }
        map.put("msg","登录失败");
        return map;
    }

    @PostMapping("/isLogin")
    public Object isLogin() {
        Map<Object, Object> map = new HashMap<>();
        map.put("msg","当前会话是否登录：" + StpUtil.isLogin());
        return map;
    }

}
