package org.artemis.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowedOrigins("*")
            .allowCredentials(true);
    }

//    @Bean
//    public FilterRegistrationBean<SimpleCorsFilter> loggingFilter(){
//        FilterRegistrationBean<SimpleCorsFilter> registrationBean
//            = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new SimpleCorsFilter());
//        registrationBean.addUrlPatterns("/**");
//
//        return registrationBean;
//    }
}
