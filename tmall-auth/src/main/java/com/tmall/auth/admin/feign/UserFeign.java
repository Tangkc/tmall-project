package com.tmall.auth.admin.feign;

import com.example.core.user.controller.UserInfo;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "tmall-core")
public interface UserFeign {


    /**
     * 添加超级账号
     * @param info
     * @return
     */

    @GetMapping("/getUserInfo")
    String getUserInfo(@RequestParam(name = "info") UserInfo info,@RequestParam(name = "names") List<String> names);

    /**
     * 添加超级账号
     * @param info
     * @return
     */
    @PostMapping("/getUserInfo2")
    String getUserInfo2(@RequestBody UserInfo info);

    /**
     * 添加超级账号
     * @param info
     * @return
     */
    @PostMapping("/getUserInfo3")
    String getUserInfo3(@RequestBody com.tmall.auth.admin.feign.UserInfo info);

}
