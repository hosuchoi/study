package com.lake.smartway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SmartwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartwayApplication.class, args);
	}

}
