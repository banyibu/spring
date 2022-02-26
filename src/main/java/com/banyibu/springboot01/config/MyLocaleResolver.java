package com.banyibu.springboot01.config;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 地区解析
 */
public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取语言参数
        String language = request.getParameter("l");
        if(StringUtils.hasText(language)){
            //语言，国家
            String[] languageSplit = language.split("_");
            return new Locale(languageSplit[0], languageSplit[1]);
        }

        return Locale.getDefault();//默认语言
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
