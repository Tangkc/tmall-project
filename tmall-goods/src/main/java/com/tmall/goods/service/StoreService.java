package com.tmall.goods.service;

import com.tmall.goods.req.SaveStoreReq;

public interface StoreService {

    /**
     * 新增一个店
     * @param saveStoreReq 参数
     * @return 店id
     */
    Integer saveStoreInfo(SaveStoreReq saveStoreReq) throws Exception;


}
