package edu.nf.gc.web.config;

import edu.nf.gc.web.interceptors.AuthorityInterceptor;
import edu.nf.gc.web.interceptors.LoginInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author wangl
 * @date 2019/11/18
 * 取代spring mvc配置文件
 */
@Configuration
/**
 * 报扫描，只扫描controller包
 */
@ComponentScan(basePackages = "edu.nf.gc.web")
/**
 * 启用mvc注解驱动，
 * 等同于配置文件<mvc:annotation-driven/>
 */
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

//    /**
//     * 启用默认servlet处理静态资源
//     * @param configurer
//     */
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    /**
     * 配置内部资源视图解析器
     * @return
     */
    /*public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/logins","/page/login.html","/page/js/**","/page/css/**","/page/images/**","/page/themes/**","/page/vendor/**");
        registry.addInterceptor(new AuthorityInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/logins","/page/login.html","/page/js/**","/page/css/**","/page/images/**","/page/themes/**","/page/vendor/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/page/**").addResourceLocations("/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }
}
