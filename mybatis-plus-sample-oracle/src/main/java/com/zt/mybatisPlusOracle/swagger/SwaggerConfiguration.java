package com.zt.mybatisPlusOracle.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableOpenApi
public class SwaggerConfiguration {

    /**
     * 配置第一个swagger配置类，该类只扫描com.demo.swagger.test下的方法，并且分组为test
     * @return
     */

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).enable(true)
                // 允许忽略预定义的响应消息默认值
                .useDefaultResponseMessages(false)
                .select()
                /*
                 * 通过apis方法，basePackage可以根据包路径来生成特定类的API
                 * any方法是默认所有都有效，
                 * none方法都无效；
                 * withClassAnnotation根据类注解，withMethodAnnotation是根据方法注解；一般我们用的是 basePackage方法
                 */
                .apis(RequestHandlerSelectors.basePackage("com.zt.mybatisPlusOracle.controller"))
                /*
                 * 根据请求路径的paths方法
                 *  1.ant匹配路径
                 *  2.any是匹配任意路径
                 *  3.none是都不匹配
                 *  4.regex是正则匹配
                 */
                .paths(PathSelectors.any())
                .build().globalRequestParameters(parameter())
                .groupName("test");
    }


    /**
     * 文档描述信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger项目接口文档")
                .description("swagger项目描述")
                .contact(new Contact("jieya", "https://blog.csdn.net/u010913170/article/details/125081576", ""))
                .version("1.0")
                .build();
    }

    /**
     * 全局参数(如header中的token)
     *
     * @return List<Parameter>
     */
    private List<RequestParameter> parameter() {
        List<RequestParameter> globalRequestParameters = new ArrayList<>();
        RequestParameter authorization = new RequestParameterBuilder()
                //自定义字段
                .name("Authorization")
                // 描述
                .description("请求令牌(登录时不填写,其他接口请求需要此参数)")
                // 自定义字段的在哪里显示
                .in(ParameterType.HEADER)
                // 是否必填
                .required(false)
                .build();
        globalRequestParameters.add(authorization);
        return globalRequestParameters;
    }

}
