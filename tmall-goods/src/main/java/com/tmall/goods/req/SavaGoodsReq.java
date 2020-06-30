package com.tmall.goods.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SavaGoodsReq {
    @ApiModelProperty(value = "商品名称", required = true)
    @NotEmpty(message = "商品名称不能为null")
    private String goodsName;
    @ApiModelProperty(value = "商品描述", required = true)
    @NotEmpty(message = "商品描述不能为null")
    private String goodsDiscription;
    @ApiModelProperty(value = "商品价格", required = true)
    @NotEmpty(message = "商品价格不能为null")
    private int goodsPrice;
    @ApiModelProperty(value = "商店id", required = true)
    @NotEmpty(message = "商店id不能为null")
    private int store_id;
}
