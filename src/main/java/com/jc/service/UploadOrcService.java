package com.jc.service;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.Map;

/**
 * 上传Orc文件
 * @author Autism
 */
public interface UploadOrcService {

    /**
     * 登录三销系统
     * @param httpUrl
     * @param filePath
     * @return
     * @throws IOException
     * @throws UnirestException
     */
    String uploadByOrc(String httpUrl,String filePath) throws IOException, UnirestException;
    
}
