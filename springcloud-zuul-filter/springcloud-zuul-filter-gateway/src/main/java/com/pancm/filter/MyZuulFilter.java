package com.pancm.filter;


import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;




/**
 * 
* @Title: MyZuulFilter
* @Description: 自定义过滤器实现类
  用于校验请求参数是否合法
* @Version:1.0.0  
* @Since: jdk1.8
* @author pancm
* @date 2019年5月7日
 */
@Component
public class MyZuulFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		//此方法可以根据请求的url进行判断是否需要拦截
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//获取请求的上下文类 注意是：com.netflix.zuul.context包下的
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		ctx.addZuulResponseHeader("Content-type", "text/json;charset=UTF-8");
		ctx.getResponse().setCharacterEncoding("UTF-8");
		System.out.println("请求地址:"+request.getRequestURI());
		String token = request.getParameter("token");
		String msg="请求成功!";
		if(token==null) {
			//使其不进行转发
		   ctx.setSendZuulResponse(false);
		   msg="请求失败！原因是token为空！";
		   ctx.setResponseBody(msg);
		   ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
		   //或者添加一个额外参数也可以 传递参数可以使用
//		   ctx.set("checkAuth",false);
		}
		System.out.println(msg);
		return msg;
	}

	@Override
	public String filterType() {
		//前置过滤器
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		//执行顺序  0 靠前执行 在spring cloud zuul提供的pre过滤器之后执行，默认的是小于0的。	
		//除了参数校验类的过滤器 一般上直接放在 PreDecoration前
		//即：PRE_DECORATION_FILTER_ORDER - 1;
		//常量类都在：org.springframework.cloud.netflix.zuul.filters.support.FilterConstants 下
		return 0;
	}
	
	@Bean
	public MyZuulFilter zuulFilter() {
	    return new MyZuulFilter();
	}

}
