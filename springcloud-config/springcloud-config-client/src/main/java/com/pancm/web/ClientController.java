package com.pancm.web;

import org.springframework.beans.factory.annotation.Value;
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
* @Version:1.0.0  
* @author pancm
* @date 2018年1月3日
 */
@RestController
public class ClientController {
	
	@Value("${word}")
	private String word;
	
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return name+","+this.word;
    }
}