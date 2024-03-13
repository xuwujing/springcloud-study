package com.pancm.web;

import com.pancm.fegin.CosTestClient;
import com.pancm.fegin.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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

    @Autowired
    private CosTestClient cosTestClient;

    @GetMapping
    public String test() {
        return testClient.getName();
    }



    @PostMapping("/upload")
    public Map upload(@RequestParam("file") MultipartFile multipartFile) {
        return cosTestClient.upload(multipartFile);
    }


}