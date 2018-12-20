package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @Title: Application
 * @Description: 程序入口 EnableDiscoveryClient 表示该项目就具有了服务注册的功能
 
 *  在浏览器输入http://localhost:9001//hello?name=pancm 即可查看信息
 * @Version:1.0.0
 * @author pancm
 * @date 2018年3月29日
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class App {

	@RequestMapping("/hello")
	public String index(@RequestParam String name) {
		return name + ",Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("客户端服务启动...");
	}
}
