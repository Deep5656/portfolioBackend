package com.portfolio.projecthandle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjecthandleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecthandleApplication.class, args);
	}

}
