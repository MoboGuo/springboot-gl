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
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 配置内部资源视图解析器
     */
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //配置前缀, 不用加static文件夹路径, 后面有文件夹路径在加上 : /page/
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".html");
        registry.viewResolver(viewResolver);
        super.configureViewResolvers(registry);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry){
        //设置访问路径为 “/” 跳转到指定页面
        registry.addViewController("/").setViewName("forward:/login/login.html");
        //设置为最高优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }


}
