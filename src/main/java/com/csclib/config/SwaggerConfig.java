package com.csclib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/** Swagg3配置类 */
@Component
@EnableOpenApi
public class SwaggerConfig {

  @Bean
  public Docket setDocket() {
    return new Docket(DocumentationType.OAS_30)
        .apiInfo(setApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.csclib.controller"))
        .build();
  }

  public ApiInfo setApiInfo() {
    Contact contact = new Contact("lewis", "www.csclib.com", "xylewis@126.com");
    return new ApiInfo(
        "中电凯源信息管理系统",
        "中电凯源信息管理系统",
        "V1.0",
        "www.csclib.com",
        contact,
        "Apache 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0",
        new ArrayList());
  }
}
