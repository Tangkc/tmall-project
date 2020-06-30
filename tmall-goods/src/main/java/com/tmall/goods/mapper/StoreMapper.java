package com.tmall.goods.mapper;

import com.tmall.goods.mapper.dto.StoreDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StoreMapper  {


    Integer saveStoreDto(@Param("storeDto") StoreDto storeDto);


    int countStoreInfo(@Param("storeBusinessLicenseId") String storeBusinessLicenseId);

}
