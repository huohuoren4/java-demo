package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 文档访问地址：http://ip:port/swagger-ui/index.html
 *
 * @author Admin
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket createRestApis(Environment environment) {
        return new Docket(DocumentationType.OAS_30)
                .enable(getEnv(environment))//是否启用：注意生产环境需要关闭
                .groupName("spring-boot-2.7.3")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
//                .paths(PathSelectors.any())
                // 只扫面 "/user/**" 路径下
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }

    @Bean
    public Docket createRestApis01(Environment environment) {
        return new Docket(DocumentationType.OAS_30)
                .enable(getEnv(environment))//是否启用：注意生产环境需要关闭
                .groupName("spring-boot-2.7.3-v1")
                .apiInfo(apiInfo01())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用swagger生成的接口文档")
                .description("开发测试")
                // 服务条款URL
                .termsOfServiceUrl("https://www.baidu.com/")
                // 作者信息
                .contact(new Contact("qihh", "https://www.baidu.com/", "qihh@136.com"))
                .version("0.0.1")
                .build();
    }

    private ApiInfo apiInfo01() {
        return new ApiInfoBuilder()
                .title("使用swagger生成的接口文档-v1")
                .description("开发测试")
                // 服务条款URL
                .termsOfServiceUrl("https://www.baidu.com/")
                // 作者信息
                .contact(new Contact("qihh", "https://www.baidu.com/", "qihh@136.com"))
                .version("0.0.1-v1")
                .build();
    }

    public boolean getEnv(Environment environment){
        Profiles profiles = Profiles.of("dev");
        return environment.acceptsProfiles(profiles);
    }

}