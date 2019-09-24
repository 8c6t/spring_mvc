package com.hachicore.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new AnotherInterceptor())
            .addPathPatterns("/hi")
            .order(-1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**")
                .addResourceLocations("classpath:/mobile/")
                // .addResourceLocations("classpath:/mobile/", "file:/User/Haru/files/")
                // .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
                .resourceChain(true); // 캐시 사용 여부(dev: true / prod: false)

    }
}
