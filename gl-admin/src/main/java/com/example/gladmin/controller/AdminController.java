package com.example.gladmin.controller;

import cn.dev33.satoken.stp.StpUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final String prefix = "admin";

    @ApiOperation(value = "首页", notes = "首页")
    @GetMapping({"", "/index"})
    public String index(HttpServletRequest request) {
        return prefix + "/index";
    }


    @ApiOperation(value = "请求到登陆界面", notes = "请求到登陆界面")
    @GetMapping("/login")
    public String login(ModelMap modelMap) {
        return "login";
    }
}
