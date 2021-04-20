package com.jc.service.impl;

import com.alibaba.fastjson.JSON;
import com.jc.service.LoginService;
import com.jc.util.HttpClientUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Autism
 */
@Service
public class LoginServiceImpl implements LoginService {

    public String httpLogin(String httpUrl,Map LoginParams) throws IOException {
        HashMap hashMap = JSON.parseObject(HttpClientUtil.doPost(httpUrl,LoginParams), HashMap.class);
        HttpClientUtil.bearer="Bearer " + hashMap.get("access_token");
        System.out.println("Bearer " + hashMap.get("access_token"));
        return HttpClientUtil.bearer;
    }
}
