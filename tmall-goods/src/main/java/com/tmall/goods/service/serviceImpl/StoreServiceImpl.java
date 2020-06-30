package com.tmall.goods.service.serviceImpl;

import com.tmall.goods.mapper.StoreMapper;
import com.tmall.goods.mapper.dto.StoreDto;
import com.tmall.goods.req.SaveStoreReq;
import com.tmall.goods.service.StoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Integer saveStoreInfo(SaveStoreReq saveStoreReq) throws Exception{
        StoreDto storeDto = new StoreDto();
        BeanUtils.copyProperties(saveStoreReq, storeDto);
        int count = storeMapper.countStoreInfo(saveStoreReq.getStoreBusinessLicenseId());
        if(count==1){
            throw new Exception("该店已被注册过哦！");
        }
        Integer line = storeMapper.saveStoreDto(storeDto);
        if(line ==1){
            return storeDto.getId();
        }
        return -1;
    }
}
