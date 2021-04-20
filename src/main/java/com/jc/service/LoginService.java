package com.jc.service;

import java.io.IOException;
import java.util.Map;


/**
 * @author Autism
 */
public interface LoginService {

    /**
     * 登录三销系统
     * @param httpUrl
     * @param LoginParams
     * @return
     * @throws IOException
     */
    String httpLogin(String httpUrl,Map LoginParams) throws IOException;
}
