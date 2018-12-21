package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
* @Title: Application
* @Description:
* 程序入口 
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HystrixConsumerApplication2 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixConsumerApplication2.class, args);
		  System.out.println("hystrix第二个消费者服务启动...");
	}
}