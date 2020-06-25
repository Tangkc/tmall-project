package com.tmall.auth.admin.service.serviceImpl;


import com.alibaba.nacos.common.util.Md5Utils;
import com.example.core.user.controller.AgeInfo;
import com.example.core.user.controller.UserInfo;
import com.example.core.user.util.JwtUtil;
import com.tmall.auth.admin.controller.req.LoginReq;
import com.tmall.auth.admin.controller.req.UserInfoReq;
import com.tmall.auth.admin.exception.BadServerException;
import com.tmall.auth.admin.feign.UserFeign;
import com.tmall.auth.admin.mapper.AdminMapper;
import com.tmall.auth.admin.mapper.dto.UserInfoDto;
import com.tmall.auth.admin.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public int insertUserInfo(UserInfoReq userInfoReq) {
        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(userInfoReq, dto);
        if (adminMapper.countUserInfo(userInfoReq.getPhoneNum()) != 0) {
            return -1;
        }
        dto.setPassWord(Md5Utils.getMD5(dto.getPassWord().getBytes()));
        int row = adminMapper.insertUserInfo(dto);
        if (row != 1) {
            return -1;
        }
        return dto.getUserId();
    }

    @Override
    public String login(LoginReq loginReq) {
        String password = Md5Utils.getMD5(loginReq.getPassWord().getBytes());
        loginReq.setPassWord(password);
        UserInfoDto userInfoDto = adminMapper.getUserInfo(loginReq);
        if (Objects.isNull(userInfoDto)) {
            throw new BadServerException("该用户不存在");
        }
        if (!StringUtils.equals(password, userInfoDto.getPassWord())) {
            throw new BadServerException("密码不正确");
        }
        return JwtUtil.sign(userInfoDto.getUserName(), userInfoDto.getPhoneNum());

    }
}
