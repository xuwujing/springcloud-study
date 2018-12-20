package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
* @Title: Application
* @Description: 
* springcloud服务入口
  EnableEurekaServer 注解启动一个服务注册中心
  在浏览器输入http://localhost:8000  即可查看相关信息
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@EnableEurekaServer
@SpringBootApplication
public class App {
  public static void main(String[] args) {
      SpringApplication.run(App.class, args);
      System.out.println("注册中心服务启动...");
  }
}
