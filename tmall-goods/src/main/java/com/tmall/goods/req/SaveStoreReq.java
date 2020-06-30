package com.tmall.goods.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SaveStoreReq {


    @ApiModelProperty(value = "商店名称", required = true)
    @NotEmpty(message = "商店名称不能为null")
    private String storeName; //商店名称
    @ApiModelProperty(value = "商店描述", required = true)
    @NotEmpty(message = "商店描述不能为null")
    private String storeDescription; //商店描述
    @ApiModelProperty(value = "商店营业执照base64", required = true)
    @NotEmpty(message = "商店营业执照不能为null")
    private String storeBusinessLicense; //营业执照 base64
    @ApiModelProperty(value = "商店营业执照id", required = true)
    @NotEmpty(message = "商店营业执照Id不能为null")
    private String storeBusinessLicenseId; //营业执照id
    @ApiModelProperty(value = "店长姓名", required = true)
    @NotEmpty(message = "店长姓名不能为null")
    private String storeManagerName; //店长姓名
    @ApiModelProperty(value = "店长电话", required = true)
    @NotEmpty(message = "店长电话不能为null")
    private String storeManagerPhone; //店长电话
    @ApiModelProperty(value = "店长身份证号", required = true)
    @NotEmpty(message = "店长身份证号不能为null")
    private String storeManagerIdcard;// 店长身份证号

}
