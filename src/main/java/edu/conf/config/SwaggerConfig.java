package edu.conf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.conf.handler"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo webAipInfo() {
        return new ApiInfoBuilder()
                .title("国际会议网站")
                .description("本文档描述了新闻微服务接口定义")
                .version("1.0.0")
                .build();
    }
}

/**
 * {
 *   "code": 200,
 *   "success": true,
 *   "msg": "ok",
 *   "data": true,
 *   "cookie": null
 * }
 */
