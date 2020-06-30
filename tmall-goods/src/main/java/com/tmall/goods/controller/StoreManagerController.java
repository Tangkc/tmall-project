package com.tmall.goods.controller;



import com.tmall.goods.req.SaveStoreReq;
import com.tmall.goods.service.StoreService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("tamll/store")
@Api(value = "商店管理类", tags = "store-information")
public class StoreManagerController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/registStore")
    public Integer saveStoreInfo(@RequestBody SaveStoreReq saveStoreReq) throws Exception {

        return storeService.saveStoreInfo(saveStoreReq);
    }
}
