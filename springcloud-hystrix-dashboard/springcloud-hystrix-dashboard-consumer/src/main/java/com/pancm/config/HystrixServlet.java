package com.pancm.config;

import org.springframework.boot.autoconfigure.web.ServerProperties.Servlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
* @Title: HystrixServlet
* @Description: 初始化Hystrix的bean
* @Version:1.0.0  
* @author pancm
* @date 2018年12月24日
*/
@Component
public class HystrixServlet extends Servlet{

	
	
	/**
	 *  指定 hystrix 的路径
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
	
}
