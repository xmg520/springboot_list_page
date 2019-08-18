package com.mzx.springbootweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mzx
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    /**
     *
     * @param registry
     *
     * 通过 addPathPatterns 设置拦截器作用路径
     * addPathPatterns("/**")对所有请求都拦截,包括静态资源
     * .excludePathPatterns("/index.html","/","/user/login","/static/**")排除指定作用路径
     *
     * 妙用：
     * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
     * 可以通过在此方法下配置，
     *  registry.addViewController("/toLogin").setViewName("login");
     * 直接访问http://localhost:8080/toLogin就跳转到login.jsp页面了
     */
    //此处设置 /page/user/allUsers.html 和 /findAllUser为拦截路径，拦截规则在LoginInterceptor实现
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(new String[] { "/page/user/allUsers.html" })
                .addPathPatterns(new String[] { "/findAllUser" });
    }
}
