package com.jc.job;

import com.jc.service.LoginService;
import com.jc.service.UploadOrcService;
import com.jc.util.HttpClientUtil;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 定时任务执行器
 *
 * @Author: Autism
 * @Date: 2021/4/20
 */
@Component
@EnableScheduling   // 1.开启定时任务
public class JobExecutor {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UploadOrcService uploadOrcService;

    /**用户手机号*/
    @Value("${spring.jccloud.LoginUrl}")
    private String loginUrl;
    /**用户手机号*/
    @Value("${spring.jccloud.userPhoneNumber}")
    private String userPhoneNumber;

    /**用户密码*/
    @Value("${spring.jccloud.userPassword}")
    private String userPassword;

    /** 类型*/
    @Value("${spring.jccloud.type:0}")
    private String type;

    /*** 日销上传接口地址*/
    @Value("${spring.jccloud.daySaleHttpUrl}")
    private String daySaleHttpUrl;

    /*** 日销上传文件地址*/
    @Value("${spring.jccloud.daySaleFilePath}")
    private String daySaleFilePath;

//    /**
//     * 每天定时登录系统
//     */
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void httpLoginJob() throws IOException {
//        Map params = new HashMap(5);
//        params.put("username",userPhoneNumber);
//        params.put("password",userPassword);
//        params.put("type",type);
//        loginService.httpLogin(loginUrl,params);
//    }

    /**
     * 定时上传日销orc文件
     * @throws IOException
     */
    @Scheduled(cron = "0/20 * * * * ?")
    public void settingData() throws IOException, UnirestException {
        //登录系统
        Map params = new HashMap(5);
        params.put("username",userPhoneNumber);
        params.put("password",userPassword);
        params.put("type",type);
        loginService.httpLogin(loginUrl,params);
        //上传文件日销售文件
        uploadOrcService.uploadByOrc(daySaleHttpUrl,daySaleFilePath);
    }
}
