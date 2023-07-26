package org.edupoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppTodoApplication extends SpringBootServletInitializer {

	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		System.out.println("configure!!");
		return builder.sources(AppTodoApplication.class);
		
	}	
	public static void main(String[] args) {
		SpringApplication.run(AppTodoApplication.class, args);
	}

}
