/**
 * 
 */
package com.devs4j.mvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * By default HandlerInterceptors apply to all the @Controllers 
 * @author raidentrance
 *
 */
public class PostInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime=System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long startTime = (Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		Long endTime=System.currentTimeMillis();
		modelAndView.addObject("responseTime", endTime-startTime);
	}

	

}
