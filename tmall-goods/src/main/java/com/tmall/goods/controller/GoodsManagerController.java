package com.tmall.goods.controller;


import com.example.core.user.controller.UserInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("tamll/goods")
@Api(value = "商品管理", tags = "goods-information")
public class GoodsManagerController {





    @PostMapping("/saveGoods")
    public String getUserInfo2(@RequestBody UserInfo info) {

        return info.getName();
    }

    @PostMapping("/getUserInfo3")
    public String getUserInfo3(@RequestBody UserInfo info) {

        return info.getName();
    }

}
