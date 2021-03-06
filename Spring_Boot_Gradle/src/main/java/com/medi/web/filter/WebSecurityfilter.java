package com.medi.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.medi.web.util.JwtTokenUtil;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebSecurityfilter implements Filter {
	
	private JwtTokenUtil jwtTokenUtil;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Initiating WebFilter >> ");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if(null==jwtTokenUtil) {
			ServletContext servletContext = request.getServletContext();
	        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	        jwtTokenUtil = webApplicationContext.getBean(JwtTokenUtil.class);
		}
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if(httpServletRequest.getRequestURI().contains("services/login")) {
			chain.doFilter(request, response);
			return;
		}
		if(null != httpServletRequest.getHeader("Authorization")) {
			jwtTokenUtil.retrieveUserFromToken(httpServletRequest.getHeader("Authorization").toString());
			chain.doFilter(request, response); 
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroying WebFilter >> ");
	}
	
}
