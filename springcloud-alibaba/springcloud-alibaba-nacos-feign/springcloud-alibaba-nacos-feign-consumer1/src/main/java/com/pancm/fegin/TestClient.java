package com.pancm.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "jeecg-nacos-consumer2")
@Component
public interface TestClient {
    @GetMapping(value = "/config/getName")
    String getName();
}