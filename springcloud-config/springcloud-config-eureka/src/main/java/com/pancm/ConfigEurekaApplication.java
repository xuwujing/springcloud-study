package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
* @Title: ConfigEurekaApplication
* @Description: 
* springcloud服务入口
  EnableEurekaServer 注解启动一个服务注册中心
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigEurekaApplication.class, args);
		 System.out.println("config 注册中心服务启动...");
	}
}
