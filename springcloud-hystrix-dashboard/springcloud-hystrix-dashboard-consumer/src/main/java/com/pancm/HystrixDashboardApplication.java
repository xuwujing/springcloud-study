package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
* @Title: Application
* @Description:
* 程序入口 
* EnableDiscoveryClient: 启用服务注册与发现
  EnableHystrixDashboard 启用 HystrixDashboard 断路器看板 相关配置
  EnableCircuitBreaker  启用hystrix
  在浏览器输入 http://localhost:9010/hystrix 
 然后在到界面提示的地址输入: http://localhost:9010/hystrix.stream
 如果提示loading，那么使没有进行访问，在浏览器输入:http://localhost:9010/hello/pancm 进行访问之后
 刷新该界面就可以看到了
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients
public class HystrixDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
		  System.out.println("hystrix dashboard 服务启动...");
	}
}