package com.kj.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问的路径
        registry.addMapping("/**")
                // 是否允许证书（cookies）
                .allowCredentials(true)
                // 允许跨域访问的源
                .allowedOriginPatterns("*")
                // 运行跨域的方法
                .allowedMethods("GET", "POST", "OPTIONS")
                // 跨域允许时间
                .maxAge(60);
    }

}
