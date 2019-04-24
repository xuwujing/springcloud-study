package com.pancm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
* @Title: Application
* @Description:
* 程序入口 
* EnableDiscoveryClient: 启用服务注册与发现
  EnableFeignClients:    启用feign进行远程调用
  EnableZuulProxy:  开启zuul的功能
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy   
public class ZuulConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulConsumerApplication.class, args);
		 System.out.println("zuul 第一个服务启动...");
	}
}