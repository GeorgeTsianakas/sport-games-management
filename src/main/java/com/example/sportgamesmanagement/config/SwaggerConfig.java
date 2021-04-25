//package com.example.sportgamesmanagement.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.hateoas.client.LinkDiscoverer;
//import org.springframework.hateoas.client.LinkDiscoverers;
//import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
//import org.springframework.plugin.core.SimplePluginRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@EnableWebMvc
////@EnableSwagger2WebMvc
//@EnableSwagger2
//@Configuration
//public class SwaggerConfig extends WebMvcConfigurerAdapter {
//
////    @Bean
////    public LinkDiscoverers discoverers() {
////        List<LinkDiscoverer> plugins = new ArrayList<>();
////        plugins.add(new CollectionJsonLinkDiscoverer());
////        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
////    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .pathMapping("/")
//                .apiInfo(metaData());
//    }
//
//    private ApiInfo metaData() {
//
//        Contact contact = new Contact("George", " ",
//                "gtsianakas94@gmail.com");
//
//        return new ApiInfo(
//                "Sport Games Management API",
//                "Sport Games Management API Implementation",
//                "1.0",
//                "Terms of Service",
//                contact,
//                " ",
//                " ",
//                new ArrayList<>());
//    }
//
//}
