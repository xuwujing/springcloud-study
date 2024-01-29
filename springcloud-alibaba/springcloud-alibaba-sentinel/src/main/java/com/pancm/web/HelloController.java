package com.pancm.web;



import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Author pancm
 * @Description 官方示例文档
 * @Date  2024/1/26
 * @Param
 * @return
 **/
@RestController
@RequestMapping("hello")
public class HelloController {





    @RequestMapping(value = "/say", method = GET)
    @SentinelResource("hello")
    public String say(@RequestParam String name) {
        return "say "+name+ " hello !";
    }

}