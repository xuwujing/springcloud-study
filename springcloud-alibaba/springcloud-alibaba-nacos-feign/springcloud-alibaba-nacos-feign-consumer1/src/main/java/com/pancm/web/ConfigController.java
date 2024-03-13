package com.pancm.web;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("config")
public class ConfigController {

    @RequestMapping(value = "/getAge", method = GET)
    public String getAge() {
        return "18";
    }

}