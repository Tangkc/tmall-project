package com.tmall.auth.admin.controller;


import com.tmall.auth.admin.commen.CommonResult;
import com.tmall.auth.admin.controller.req.LoginReq;
import com.tmall.auth.admin.controller.req.UserInfoReq;
import com.tmall.auth.admin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(value = "用户信息", tags = "user-information")
@RequestMapping("tmall/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "注册用户接口",
            notes = "用户注册",
            consumes = "application/json"
    )
    @PostMapping("/regist")
    public CommonResult<Integer> registUserInfo(@RequestBody UserInfoReq info) {
        int userId = adminService.insertUserInfo(info);
        if(userId!=-1){
            return CommonResult.commonSuccess(userId);
        }
        return CommonResult.commonfail("该用户已存在");
    }

    @ApiOperation(value = "登陆",
            notes = "登陆",
            consumes = "application/json"
    )
    @PostMapping("/login")
    public CommonResult<String> login(@RequestParam LoginReq loginReq){
       if(StringUtils.isEmpty(loginReq.getUserName()) && StringUtils.isEmpty(loginReq.getPhoneNum())){
           return CommonResult.commonfail("用户名或手机号不能同时为null");
       }
       return CommonResult.commonSuccess(adminService.login(loginReq));
    }

}
