package com.shablobank.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableAsync
@EnableJpaRepositories
@EnableScheduling
public class MainApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}


}
