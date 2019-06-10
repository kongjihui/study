package com.example.demo.common;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: FilterConfig.java 
 * @Package dcc.aurora.config 
 * @Description:  添加过滤器
 * @author 
 * @date 
 * @version V1.0
 */
@Configuration
public class FilterConfig {

	/**bean注入方式配置Filter
     * 连接池 配置 Druid 监控信息显示页面    start
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
    public FilterRegistrationBean filterRegistration(WebStatFilter webStatFilter) {
    	FilterRegistrationBean registration = new FilterRegistrationBean(webStatFilter);
        registration.setName("DruidWebStatFilter");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js ,*.gif ,*.jpg ,*.png ,*.css ,*.ico ,/druid /*");
        initParameters.put("profileEnable", "true");
        initParameters.put("sessionStatMaxCount", "1000");
        initParameters.put("principalSessionName", "customerName");
        registration.setInitParameters(initParameters);
        registration.addUrlPatterns("/*");
        
    	DelegatingFilterProxy proxy = new DelegatingFilterProxy();
    	proxy.setTargetFilterLifecycle(true);
    	proxy.setTargetBeanName("shiroFilter");
    	registration.setFilter(proxy);
        
        return registration;
    }
    
	/**bean注入方式配置Filter
     * shiroFilter
     */
    @Bean
    public FilterRegistrationBean filterRegistration() {
    	FilterRegistrationBean registration = new FilterRegistrationBean();
    	DelegatingFilterProxy proxy = new DelegatingFilterProxy();
    	proxy.setTargetFilterLifecycle(true);
    	proxy.setTargetBeanName("shiroFilter");
    	registration.setFilter(proxy);
        registration.setName("shiroFilter");
        registration.addInitParameter("targetFilterLifecycle", "true");
        proxy.setTargetBeanName("shiroFilter");
        registration.setFilter(proxy);
        registration.addUrlPatterns("/*");
        return registration;
    }
    
 	/**bean注入方式配置Filter
     * encodingFilter
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public FilterRegistrationBean filterRegistration(CharacterEncodingFilter characterEncodingFilter) {
    	FilterRegistrationBean registration = new FilterRegistrationBean(characterEncodingFilter);
        registration.setName("encodingFilter");
        registration.isAsyncSupported();
        registration.addInitParameter("encoding", "UTF-8");
        registration.addUrlPatterns("/*");
        return registration;
    }
}
