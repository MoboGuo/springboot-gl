package com.example.gladmin.controller;


import com.example.core.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mobo
 */
@RestController
@RequestMapping("/api")
@Api(tags = "redis测试")
public class RedisTestController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/saveWithRedis")
    @ApiOperation("保存到redis")
    public boolean saveWithRedis(@RequestParam String key,
                                @RequestParam String value){
        return redisService.set(key, value, 6000);
    }

    @GetMapping("/getWithRedis")
    @ApiOperation("缓存中拿")
    public String getWithRedis(@RequestParam String key) {
        return redisService.get(key).toString();
    }
}
