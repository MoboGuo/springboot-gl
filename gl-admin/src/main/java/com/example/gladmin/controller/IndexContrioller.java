package com.example.gladmin.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Api("首页模块")
@Controller
public class IndexContrioller {

    @GetMapping("/")
    public String index(ModelMap map) {
        return "index";
    }
}
