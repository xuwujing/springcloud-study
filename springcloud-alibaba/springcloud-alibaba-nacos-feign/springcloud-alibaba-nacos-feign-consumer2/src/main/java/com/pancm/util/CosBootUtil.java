package com.pancm.util;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.CannedAccessControlList;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Description: 腾讯云 css 上传工具类(高依赖版)
 * @Date: 2024/3/11
 * @author: pcm
 */
@Slf4j
public class CosBootUtil {

    private static String region;
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String bucketName;
    private static String url;

    public static void setRegion(String region) {
        CosBootUtil.region = region;
    }

    public static void setAccessKeyId(String accessKeyId) {
        CosBootUtil.accessKeyId = accessKeyId;
    }

    public static void setAccessKeySecret(String accessKeySecret) {
        CosBootUtil.accessKeySecret = accessKeySecret;
    }

    public static void setBucketName(String bucketName) {
        CosBootUtil.bucketName = bucketName;
    }

    public static void setUrl(String url) {
        CosBootUtil.url = url;
    }

    public static String getUrl() {
        return url;
    }

    public static String getRegion() {
        return region;
    }

    public static String getAccessKeyId() {
        return accessKeyId;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }

    public static String getBucketName() {
        return bucketName;
    }

    public static COSClient getCosClient() {
        return cosClient;
    }

    /**
     * oss 工具客户端
     */
    private static COSClient cosClient = null;


    /**
     * 初始化 cos 客户端
     *
     * @return
     */
    private static COSClient initCos(String region, String secretId, String secretKey) {
        if (cosClient == null) {
            // 1 初始化用户身份信息（secretId, secretKey）。
            COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
            // 2 设置 bucket 的区域, COS 地域的简称请参照
            Region region1 = new Region(region);
            ClientConfig clientConfig = new ClientConfig(region1);
            // 3 生成 cos 客户端。
            cosClient = new COSClient(cred, clientConfig);
        }
        return cosClient;
    }

    /**
     * 上传文件至腾讯云  COS
     * 文件上传成功,返回文件完整访问路径
     * 文件上传失败,返回 null
     *
     * @param file    待上传文件
     * @param fileDir 文件保存目录
     * @return oss 中的相对文件路径
     */
    public static String upload(MultipartFile file, String fileDir) throws Exception {

        initCos(region, accessKeyId, accessKeySecret);
        StringBuilder fileUrl = new StringBuilder();
        try {
            if (StringUtils.isEmpty(fileDir)) {
                fileDir = "2024/";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            if ("".equals(fileName)) {
                fileName = file.getName();
            }

            fileName = !fileName.contains(".")
                    ? fileName + "_" + System.currentTimeMillis()
                    : fileName.substring(0, fileName.lastIndexOf(".")) + "_" + System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
            //过滤上传文件夹名特殊字符，防止攻击
            fileDir = filter(fileDir);
            fileUrl = fileUrl.append(fileDir + fileName);
            PutObjectResult result = cosClient.putObject(new PutObjectRequest(bucketName, fileUrl.toString(), file.getInputStream(), null));
            // 设置权限(公开读)
            cosClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if (result != null) {
                log.info("------文件上传成功------" + fileUrl);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return url.concat(fileUrl.toString());
    }

    private static String filter(String str) throws PatternSyntaxException {
        // 清除掉所有特殊字符
        String regEx = "[`_《》~!@#$%^&*()+=|{}':;',\\[\\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    /**
     * 获取MultipartFile文件
     *
     * @param picPath
     * @return
     */
    private static MultipartFile getMulFileByPath(String picPath) {
        FileItem fileItem = createFileItem(picPath);
        MultipartFile mfile = new CommonsMultipartFile(fileItem);
        return mfile;
    }

    private static FileItem createFileItem(String filePath) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        FileItem item = factory.createItem(textFieldName, "text/plain", true,
                "MyFileName" + extFile);
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192))
                    != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }


}