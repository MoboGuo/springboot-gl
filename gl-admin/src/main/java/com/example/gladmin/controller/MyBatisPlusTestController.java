package com.example.gladmin.controller;

import com.example.common.RespResult;
import com.example.gladmin.domain.TSysUser;
import com.example.gladmin.service.impl.MpTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lkle
 */
@RestController
@RequestMapping("/api")
public class MyBatisPlusTestController {

    @Resource
    private MpTestService mpTestService;

    @GetMapping("/getUserList")
    public RespResult getUserList() {
        return RespResult.SUCC_DATA(mpTestService.getUserList());
    }

    @GetMapping("/getUserByName")
    public RespResult getUserByName(@RequestParam String userName) {
        TSysUser user = mpTestService.getUserByName(userName);
        return RespResult.SUCC_DATA(user);
    }

}
