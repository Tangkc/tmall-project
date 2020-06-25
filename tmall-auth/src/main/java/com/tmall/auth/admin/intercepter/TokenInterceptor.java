package com.tmall.auth.admin.intercepter;


import com.alibaba.fastjson.JSON;
import com.example.core.user.util.JwtUtil;

import com.tmall.auth.admin.commen.CommonResult;
import com.tmall.auth.admin.commen.util.RedisUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lilicheng
 */
@Component
@Log4j2
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    public RedisUtil redisUtil;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("access-token");
        if (null != token) {
            if(token.equals("123456")){ //万能token
                return true;
            }
            String userId = JwtUtil.getUserId(token);
            int permission = JwtUtil.getPermission(token);
            if (redisUtil.hasKey("faceToken" + userId)) {
                //token存在
                boolean result = token.equals(redisUtil.get("faceToken" + userId));
                if (result) {
                    redisUtil.set("faceToken" + userId, token, 60 * 60 * 50);
                    return true;
                } else {
                    log.error("token认证失败 原因：token不匹配 工号：" + userId);
                    String reponse = JSON.toJSON(CommonResult.commonfail("token失败 用户信息不匹配")).toString();
                    returnJson(response, reponse);
                    return false;
                }
            } else {
                log.error("token认证失败 原因：token超时 工号：" + userId);
                String reponse = JSON.toJSON(CommonResult.commonfail("登陆超时")).toString();
                returnJson(response, reponse);
                return false;
            }
        } else {
            log.error("token认证失败 原因：token为空");
            String reponse = JSON.toJSON(CommonResult.commonfail("token 为null")).toString();
            returnJson(response, reponse);
            return false;
        }
    }


    private void returnJson(HttpServletResponse response, String json) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(json);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }
}
