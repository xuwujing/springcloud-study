package com.pancm.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Author pancm
 * @Description
 * @Date  2024/1/26
 * @Param
 * @return
 **/
@RestController
@RequestMapping("config")
public class ConfigController {


    @RequestMapping(value = "/getName", method = GET)
    public String getName() {
        return "pancm";
    }


}