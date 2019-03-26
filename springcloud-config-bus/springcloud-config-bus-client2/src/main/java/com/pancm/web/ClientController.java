package com.pancm.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
* @Title: ClientController
* @Description: springboot 接口测试
* 首先启动 Application 程序，然后在浏览器输入http://localhost:9006//hello?name=pancm 
* 即可查看信息
* 在类中添加  @RestController, 默认类中的方法都会以json的格式返回
RefreshScope: 该注解表示在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中
不过需要手动刷新，使用POST方式请求该地址就会生效:http://localhost:9006/actuator/refresh
* @Version:1.0.0  
* @author pancm
* @date 2018年1月3日
 */
@RestController
@RefreshScope
public class ClientController {
	
	@Value("${word}")
	private String word;
	
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return name+","+this.word;
    }
}