package com.guorui.springboottest03.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置视图控制器
        registry.addRedirectViewController("/","/studentLogin");
        registry.addViewController("/login").setViewName("login/studentLogin");
        registry.addViewController("/login/studentLogin").setViewName("login/studentLogin");
        registry.addViewController("/examHome").setViewName("student/examHome");
        registry.addViewController("/teacher/studentTable").setViewName("teacher/studentTable");
        registry.addViewController("/teacher/studentTable/editor").setViewName("teacher/forms");
        registry.addViewController("/teacher/examQuestionTable").setViewName("teacher/examQuestionTable");
        registry.addViewController("/teacher/examSetting").setViewName("teacher/examSetting");
        registry.addViewController("/teacher/examTable").setViewName("teacher/examTable");
        registry.addViewController("/student/examHome/*").setViewName("student/examHome");
        registry.addViewController("/student/studentHome").setViewName("student/studentHome");
        registry.addViewController("/examShow/**").setViewName("examShow");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //重写静态资源映射
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录检测拦截器
        registry.addInterceptor(new LoginHandlerInterceptor()).excludePathPatterns("/login/**","/studentLogin","/login/teacherLogin","/teacherLogin",
                "/studentLogining","/teacherLogining","/webjars/**","/getUserTeacherName","/studentRegister","/examShow/**");
    }

}
