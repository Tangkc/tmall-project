package com.tmall.auth.admin.service;

import com.tmall.auth.admin.controller.req.LoginReq;
import com.tmall.auth.admin.controller.req.UserInfoReq;

public interface AdminService {

    int insertUserInfo(UserInfoReq userInfoReq);

    String login(LoginReq loginReq);

}
