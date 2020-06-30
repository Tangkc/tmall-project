package com.tmall.goods.mapper.dto;

import lombok.Data;

@Data
public class StoreDto {

    private int id; //商店id

    private String storeName; //商店名称

    private String storeDescription; //商店描述

    private String storeBusinessLicense; //营业执照 base64

    private String storeBusinessLicenseId; //营业执照id

    private String storeManagerName; //店长姓名

    private String storeManagerPhone; //店长电话

    private String storeManagerIdcard;// 店长身份证号

}
