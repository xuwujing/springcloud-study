package com.pancm.web;

import com.pancm.fegin.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("test")
public class FeignTestController {

    @Autowired
    private TestClient testClient;


    @GetMapping
    public String test() {
        return testClient.getAge();
    }


}