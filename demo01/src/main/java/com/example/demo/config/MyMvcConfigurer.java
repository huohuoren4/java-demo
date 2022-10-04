package com.example.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;

@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {
    /**
     * 自定义视图控制器
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("test");
    }

    /**
     * 跨域访问
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(false)
                .maxAge(1800)
                .allowedOrigins("*");
    }

    /**
     * 自定义语言
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    /**
     * Shiro bean 过滤器
     * 添加shiro的内置过滤器 :
     *   anon:无需认证就可以访问
     *   authc:必须认证才可访问
     *   user：必须拥有 记住我才能用
     *   perms：拥有对某个资源的权限才能访问
     *   role:拥有某个角色权限才能访问
     * @param dwsManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("dwsManager") DefaultWebSecurityManager dwsManager){
        ShiroFilterFactoryBean sffBean = new ShiroFilterFactoryBean();
        HashMap<String, String> map = new HashMap<>();
        map.put("/", "authc");
        map.put("/index", "authc");
        map.put("/addUser", "perms[user:add]");
        map.put("/deleteUser", "perms[user:delete]");
        sffBean.setLoginUrl("/login");
        sffBean.setFilterChainDefinitionMap(map);
        sffBean.setSecurityManager(dwsManager);
        return sffBean;
    }

    /**
     * 创建安全管理器
     * @param userRealm
     * @return
     */
    @Bean(name = "dwsManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager dwsManager = new DefaultWebSecurityManager();
        dwsManager.setRealm(userRealm);
        return dwsManager;
    }

    /**
     * 创建 Realm
     * @return
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
