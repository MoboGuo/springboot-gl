package com.example.gladmin;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan(basePackages = "com.example.gladmin.dao")
public class GlAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlAdminApplication.class, args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

}
