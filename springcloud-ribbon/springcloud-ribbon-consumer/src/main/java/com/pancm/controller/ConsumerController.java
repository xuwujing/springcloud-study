package com.pancm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pancm.remote.HelloRemote;

/**
 * 
* @Title: ConsumerController
* @Description: 
* 用于做转发请求
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@RestController
public class ConsumerController {

	@Autowired
    HelloRemote helloRemote;
	
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
    	System.out.println("接受到请求参数:"+name+",进行转发到其他服务!");
        return helloRemote.hello(name);
    }

}
