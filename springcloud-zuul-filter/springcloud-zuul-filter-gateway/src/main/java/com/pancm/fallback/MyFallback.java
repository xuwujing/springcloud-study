package com.pancm.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;


/**
 * 
* @Title: MyFallback
* @Description: 自定义异常回退处理类
* @Version:1.0.0  
* @Since: jdk1.8
* @author pancm
* @date 2019年5月7日
 */
@Component
public class MyFallback implements FallbackProvider {

    @Override
    public String getRoute() {
        System.out.println("进行回退!");
        //指定回退服务
        return "springcloud-zuul-filter-server2";
    }

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

		//标记不同的异常为不同的http状态值
		if (cause instanceof HystrixTimeoutException) {
			return response(HttpStatus.GATEWAY_TIMEOUT);
		} else {
			//可继续添加自定义异常类
			return response(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//处理
	private ClientHttpResponse response(final HttpStatus status) {
		String msg="请求失败!";
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
            	//可替换成相应的json串的 看业务规定了
                return new ByteArrayInputStream(msg.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
	


    @Bean
    public MyFallback eurekaClientFallback() {
        return new MyFallback();
    }
	
}
