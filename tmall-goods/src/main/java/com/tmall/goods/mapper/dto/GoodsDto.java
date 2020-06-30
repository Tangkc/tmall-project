package com.tmall.goods.mapper.dto;


import lombok.Data;


@Data
public class GoodsDto {

    private int id;

    private String goodsName;

    private String goodsDiscription;

    private int goodsPrice;

    private String goodsImageUrls;

    private int storeId;
}
