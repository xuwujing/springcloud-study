package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 
* @Title: Application
* @Description:
	EnableTurbine: 开启turbine服务

* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
public class HystrixTurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineApplication.class, args);
		  System.out.println("hystrix turbine 服务启动...");
	}
}