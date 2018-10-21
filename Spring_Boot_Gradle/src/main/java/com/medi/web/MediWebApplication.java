package com.medi.web;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages= {"com.medi.web.model"})
@PropertySource("classpath:message.properties")
public class MediWebApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(MediWebApplication.class, args);
	}
}