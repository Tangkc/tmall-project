package com.tmall.goods.mapper;

import com.tmall.goods.mapper.dto.GoodsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface GoodsMapper {


     GoodsDto saveGoodsDto(@Param("goodsDto") GoodsDto goodsDto);


}
