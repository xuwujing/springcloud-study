package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @Title: Application
 * @Description: 程序入口 EnableDiscoveryClient 表示该项目就具有了服务注册的功能
 * @Version:1.0.0
 * @author pancm
 * @date 2018年3月29日
 */
@SpringBootApplication
@EnableDiscoveryClient
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("客户端服务启动...");
	}
}
