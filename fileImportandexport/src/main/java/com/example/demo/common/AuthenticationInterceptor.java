package com.example.demo.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Title: AuthenticationInterceptor.java 
 * @Package com.aurora.consumer.admin.interceptor 
 * @Description:用户身份认证拦截,自定义拦截器,需实现 HandlerInterceptor
 * @author 
 * @date 
 * @version V1.0
 */
@Component
public class AuthenticationInterceptor   implements HandlerInterceptor {
	
	/**
	 * @Title: preHandle 
	 * @Description: 拦截
	 * @param    preHandle 
	 * @return boolean  true向下执行 false拦截
	 * @author 
	 * @date 
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

//
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	

	
 
}

