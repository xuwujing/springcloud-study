package com.pancm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.pancm.filter.MyErrorFilter;
import com.pancm.filter.MyZuulFilter;

/**
* @Title: ZuulFilter
* @Description: 过滤器的配置
* @Version:1.0.0  
* @Since: jdk1.8
* @author pancm
* @date 2019年5月8日
*/
@Component
public class ZuulFilter {
	
	/**
	 *  自定义过滤器
	 */
	@Bean
	public MyZuulFilter zuulFilter() {
	    return new MyZuulFilter();
	}
	
	/**
	 *  自定义异常过滤器
	 */
	@Bean
	public MyErrorFilter errorFilter() {
	    return new MyErrorFilter();
	}
	
	
	
	
}
