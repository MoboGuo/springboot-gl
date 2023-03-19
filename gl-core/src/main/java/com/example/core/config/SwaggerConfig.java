package com.example.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author mobo
 */
@Configuration
public class SwaggerConfig {
    /**
     * 配置Swagger2相关的bean
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                //com包下所有API都交给Swagger2管理
                .apis(RequestHandlerSelectors.basePackage("com"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    /**
     * 此处主要是API文档页面显示信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // //大标题
                .title("springboot-gl 后台服务API接口文档")
                // 版本号
                .version("1.0")
//				.termsOfServiceUrl("NO terms of service")
                // 描述
                .description("后台API接口")
                // 作者
                .contact(new Contact("springboot-gl","",""))
                .build();
    }

}
