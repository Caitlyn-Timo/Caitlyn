package ccg.caitlyn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /*
        视图映射，/和/login/login.html都映射到login.html
     */
   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }*/


    /*
        处理点击按钮切换语言的国际化功能
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


    /* 注册登录校验拦截器*/
    @Bean
    public WebMvcConfigurer loginHandlerInterceptor() {

       WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).
                        addPathPatterns("/**").
                        excludePathPatterns("/","/login","/login.html","/signin","/static/**");
            }

           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/login.html").setViewName("login");
               registry.addViewController("/login").setViewName("login");
               registry.addViewController("/").setViewName("login");
               registry.addViewController("/main.html").setViewName("dashboard");
           }
       };
        return webMvcConfigurer;
    }
}
