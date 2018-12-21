package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
* @Title: Application
* @Description:
* 程序入口 
* EnableDiscoveryClient: 启用服务注册与发现
  EnableFeignClients:    启用feign进行远程调用
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class HystrixConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixConsumerApplication.class, args);
		  System.out.println("hystrix第一个消费者服务启动...");
	}
}