package com.framework.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyWebMvcConfig extends WebMvcConfigurationSupport {
    private static final Logger logger = LoggerFactory.getLogger(MyWebMvcConfig.class);
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //如果没有这一行，那么所有静态资源将访问不到，springboot会默认把这种当做一个请求来看
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
        logger.info("--->MyWebMvcConfig.addResourceHandlers();");
    }

}
