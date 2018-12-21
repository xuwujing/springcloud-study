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
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		  System.out.println("第三个消费者服务启动...");
	}
}