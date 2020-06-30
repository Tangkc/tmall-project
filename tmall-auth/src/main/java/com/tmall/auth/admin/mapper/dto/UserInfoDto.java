package com.tmall.auth.admin.mapper.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoDto {

    private int userId;
    private String userName;
    private int userSex;
    private String phoneNum;
    private Date creatTime;
    private int userAge;
    private String passWord;
    private int userType;


}
