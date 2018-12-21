package com.pancm.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
* @Title: HelloRemoteHystrix
* @Description:
* 熔断机制 
* 当服务生产者停止服务之后，调用
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
 */
@Component
public class HelloRemoteHystrix implements HelloRemote{

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return name+", 请求另一个服务失败!";
    }
}
