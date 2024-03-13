package com.pancm.web;

import com.pancm.util.CosBootUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        CosBootUtil.setAccessKeyId("xxx");
        CosBootUtil.setAccessKeySecret("xx");
        CosBootUtil.setBucketName("xxx");
        CosBootUtil.setRegion("xxx");
        CosBootUtil.setUrl("202403/");
        String url = CosBootUtil.upload(file, null);
        return url;
    }
}