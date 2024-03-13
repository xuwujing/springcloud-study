package com.pancm.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author pancm
 * @Description 调用jeecg-nacos-consumer1服务
 * @Date  2024/3/12
 * @Param
 * @return
 **/
@FeignClient(value = "jeecg-nacos-consumer1")
@Component
public interface TestClient {
    @GetMapping(value = "/config/getAge")
    String getAge();
}