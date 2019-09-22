package com.hachicore;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplication implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // DispatcherServlet이 사용하는 컨텍스트에 서블릿 컨텍스트를
        // 미설정시 EnableWebMvc에서 불러오는 DelegatingWebMvcConfiguration를 사용할 때
        // 서블릿 컨텍스트를 종종 참조하게 되는데 이때 제대로 빈 설정이 되지 않음
        context.setServletContext(servletContext);

        context.register(WebConfig.class);
        context.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        app.addMapping("/app/*");

    }
}
