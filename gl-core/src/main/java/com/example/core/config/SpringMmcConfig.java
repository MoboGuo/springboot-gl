package com.example.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

/**
 * @author mobo
 */
@Configuration
public class SpringMmcConfig extends DelegatingWebMvcConfiguration {
    //不配置这个无法加载swagger的静态资源，页面会报404
}

