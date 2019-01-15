package com.pancm.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 
* @Title: HelloRemote
* @Description: 
* Feign可以与Eureka和Ribbon组合使用以支持负载均衡。
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@FeignClient(name= "springcloud-feign-consumer2") //指定转发的服务名称，在application.properties中进行配置
public interface HelloRemote {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
