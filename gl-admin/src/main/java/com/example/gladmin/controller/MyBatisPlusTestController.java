package com.example.gladmin.controller;

import com.example.common.RespResult;
import com.example.gladmin.domain.SysUser;
import com.example.gladmin.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lkle
 */
@RestController
@RequestMapping("/api")
public class MyBatisPlusTestController {

    @Resource
    private SysUserService userService;

    @GetMapping("/getUserList")
    public RespResult getUserList() {
        return RespResult.SUCC_DATA(userService.list());
    }

    @GetMapping("/getUserById")
    public RespResult getUserById(@RequestParam String id) {
        SysUser user = userService.getById(id);
        return RespResult.SUCC_DATA(user);
    }

}
