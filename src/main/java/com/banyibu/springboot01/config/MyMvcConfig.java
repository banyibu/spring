package com.banyibu.springboot01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//扩展mvc配置
@Configuration
//@EnableWebMvc 该注解导入了DelegatingWebMvcConfiguration 类，该类的作用是获取所有webmvcConfig；
public class MyMvcConfig implements WebMvcConfigurer {
    //实现了视图解析器ViewResolver的类，就可以把他看作时视图解析器；

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/myindex").setViewName("index-study");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/login", "/login/submit", "/css/*", "/font/*","/image/*", "/js/*", "/data/*");
    }

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    //自定义国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //自定义一些功能，只需要写相关组件，并将它交给springboot， springboot会帮我们自动装配
    //自定义视图解析器
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
