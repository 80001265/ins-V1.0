package com.cbn.ins.core.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cbn.ins.core.model.login.LoginData;

public class SecurityLoginInterceptor implements HandlerInterceptor{
	
	/**
	 * 不需要登录验证的URL
	 */
	private List<String> excludedUrls;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestURI = request.getRequestURI();
		for(String suffix:excludedUrls){
			if(requestURI.endsWith(suffix))
				return true;
		}
		
		LoginData loginData = (LoginData) request.getSession().getAttribute("LOGGEDIN_USER");
		if(loginData != null){
			return true;
		}
		
		response.sendRedirect("/index");
		
		return false;
	}
	
	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}
}
