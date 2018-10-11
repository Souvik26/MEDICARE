package com.medi.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebSecurityfilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Initiating WebFilter >> ");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
			//TODO Custom Filter Logic Goes Here
            // Goes to default servlet
			System.out.println("Executing Filter  >> ");
			chain.doFilter(request, response); 
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroying WebFilter >> ");
	}
}
