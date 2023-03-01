package com.calcfab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author XuBowen
 * @date 2023/2/8 23:34
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder().contact(new Contact("aa", "bb", "cc")).title("swagger 946b").description("6666").build();
        docket.apiInfo(apiInfo);
        return docket;
    }
}
