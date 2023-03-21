package com.example.gladmin;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan(basePackages = "com.example.gladmin.dao")
public class GlAdminApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(GlAdminApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        //目前未配置，后续可能会用的到
        String path = env.getProperty("server.servlet.context-path");
        path = path == null ? "" : path;
        log.info("\n----------------------------------------------------------\n" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui/index.html\n" +
                "----------------------------------------------------------");
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
