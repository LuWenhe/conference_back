package edu.conf.config;

import edu.conf.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public JWTInterceptor jwtInterceptor() {
        return new JWTInterceptor();
    }

    /**
     * 将自定义的拦截器类JWTInterceptor加入进来
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                // 拦截的地址, 需要进入拦截器类
                .addPathPatterns("/**")
                // 放行的地址
                .excludePathPatterns("/login", "/news/**", "/news_category/**", "/getImages/**");
    }

}
