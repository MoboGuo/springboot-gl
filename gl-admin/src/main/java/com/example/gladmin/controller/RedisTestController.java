package com.example.gladmin.controller;


import com.example.core.service.RedisService;
import io.swagger.annotations.*;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "redis保存键", dataType = "string", defaultValue = "1"),
            @ApiImplicitParam(name = "value", value = "redis保存值", dataType = "string", defaultValue = "10"),
    })
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
