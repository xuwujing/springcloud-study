package com.pancm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
* @Title: RibbonConfiguration
* @Description: 制定负载均衡策略
* @Version:1.0.0  
* @author pancm
* @date 2019年1月15日
*/
@Configuration
public class RibbonConfiguration{
      @Bean
      public IRule ribbonRule(){
          //随机负载
          return new RandomRule();
     }
}

