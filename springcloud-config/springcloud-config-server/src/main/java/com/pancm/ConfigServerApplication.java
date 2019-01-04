package com.pancm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * 
* @Title: ConfigServerApplication
* @Description:
* 程序入口 
* EnableDiscoveryClient: 启用服务注册与发现
  EnableConfigServer:    启用config配置中心
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
		System.out.println("配置中心服务端启动成功!");
	}
}
