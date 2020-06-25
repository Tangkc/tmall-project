package com.example.core.user.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController()
@Api(value = "用户信息", tags = "user-information")
public class UserInfoController {


    @Value("${server.port}")
    private String port;

    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestParam(name = "info") UserInfo info, @RequestParam(name = "names") List<String> names) {

        return info.getName()+"tmall-core"+names.get(0);
    }

    @PostMapping("/getUserInfo2")
    public String getUserInfo2(@RequestBody UserInfo info) {

        return info.getName();
    }

    @PostMapping("/getUserInfo3")
    public String getUserInfo3(@RequestBody UserInfo info) {

        return info.getName();
    }

}
