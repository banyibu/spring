package com.banyibu.springboot01.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //账号密码配置
        Map<String, String> initParMap = new HashMap<>();
        initParMap.put("loginUsername","admin");
        initParMap.put("loginPassword","123456");
        //允许谁可以访问
        initParMap.put("allow",""); //所有人可以访问

        bean.setInitParameters(initParMap);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //过滤请求
        Map<String, String> initParMap = new HashMap<>();
        //这些访问不统计
        initParMap.put("exclusions","*.js,*.css,druid/*");
        initParMap.put("loginPassword","123456");
        return bean;
    }
}
