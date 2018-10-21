package com.medi.web;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MediWebApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(MediWebApplication.class, args);
	}
}