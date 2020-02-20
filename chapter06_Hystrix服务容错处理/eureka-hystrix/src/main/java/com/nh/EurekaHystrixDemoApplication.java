package com.nh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
public class EurekaHystrixDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHystrixDemoApplication.class, args);
	}

}
