package com.shicheng.mis.config;

import com.shicheng.mis.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 */
@Configuration
public class ShiroConfig {

    //创建ShiroFilterFactoryBean

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
       shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**  添加shiro内置过滤器，可以实现权限的拦截 
         *    常用的过滤器： 
         *       anon：无需认证可以访问 
         *       authc：必须认证之后才可访问 
         *       user：如果使用rememberMe的功能可以直接访问 
         *       perms：该资源必须得到资源授权才可以访问
         *        role：该资源必须得到角色授权才可以访问 
         * */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/test","anon");
        filterMap.put("/login","anon");
        filterMap.put("/*","authc");
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;

    }

    //创建DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建Realm
    @Bean
    public UserRealm getUserRealm(){

        return new UserRealm();
    }

}
