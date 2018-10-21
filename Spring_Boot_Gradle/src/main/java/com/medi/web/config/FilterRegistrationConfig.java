package com.medi.web.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.medi.web.filter.WebSecurityfilter;

@Component
public class FilterRegistrationConfig {
	
	@Bean
	public FilterRegistrationBean loggingFilter(){
	    FilterRegistrationBean registrationBean 
	      = new FilterRegistrationBean();
	         
	    registrationBean.setFilter(new WebSecurityfilter());
	    registrationBean.addUrlPatterns("/services/*");
	         
	    return registrationBean;    
	}
}
