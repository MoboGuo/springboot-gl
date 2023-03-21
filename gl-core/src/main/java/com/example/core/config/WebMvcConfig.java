package com.example.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author lkle
 * 视图解析器配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 解决继承WebMvcConfigurationSupport,静态资源访问不到
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设定访问静态资源路径为根目录下static文件夹下，并且访问时可直接用/代替/static/
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 配置内部资源视图解析器（在addResourceHandlers方法中映射路径的基础上）
     */
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //配置前缀
        viewResolver.setPrefix("/");
        //配置后缀
        viewResolver.setSuffix(".html");
        registry.viewResolver(viewResolver);
        super.configureViewResolvers(registry);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //配置自动打开登录页，即直接访问ip:port即可打开登录页
        //访问路径如果为 “/” 跳转到指定页面
        registry.addViewController("/").setViewName("forward:/login/login.html");
        //设置为最高优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }


}