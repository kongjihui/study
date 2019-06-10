package com.example.demo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * @Title: MvcConfig.java 
 * @Package dcc.aurora.config 
 * @Description: sprinigmv 添加自定义拦截器,配置视图等
 * @author 
 * @date 
 * @version V1.0
 */
@Configuration
@EnableWebMvc
public class MvcConfig  implements WebMvcConfigurer {

    /**
     * 自己定义的拦截器类
     * @return
     */
   @Autowired
    AuthenticationInterceptor interceptor;

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	 registry.addInterceptor(new AuthenticationInterceptor())
    	 .addPathPatterns("/**/**")
    	 .excludePathPatterns("/static/**", "/login/**","/error");
        registry.addInterceptor(interceptor);
    }


	/**
	 * 会在Spring MVC上下文中定义一个org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler，
	 * 它会像一个检查员，对进入DispatcherServlet的URL进行筛查，如果发现是静态资源的请求，就将该请求转由Web应用服务器默认的Servlet处理，
	 * 如果不是静态资源的请求，才由DispatcherServlet继续处理。
	 */
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
    
    /**
	 * 配置SpringMVC的视图解析器
	*/
	@Bean
	public ViewResolver getViewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/jsp/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}
    
	/**
	 * 配置MyErrorController需要此bean
	*/
	@Bean
	public ErrorProperties errorProperties() {
	    return new ErrorProperties();
	}
	
}
