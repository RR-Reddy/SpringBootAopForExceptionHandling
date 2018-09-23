package com.rr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ExceptionAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionAopApplication.class, args);
	}
}
