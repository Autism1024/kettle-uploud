package com.jc.service.impl;

import com.jc.service.UploadOrcService;
import com.jc.util.HttpClientUtil;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * @author Autism
 */
@Service
public class UploadOrcServiceImpl implements UploadOrcService {


    public String uploadByOrc(String httpUrl,String filePath) throws IOException, UnirestException {
        HttpResponse response = (HttpResponse) Unirest.post(httpUrl)
                .header("Authorization", HttpClientUtil.bearer)
                .field("file", new File(filePath))
                .asString();
        return response.toString();
    }
}
