package com.tmall.auth.admin.controller.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class UserInfoReq {

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @ApiModelProperty(value = "性别", required = true)
    @NotEmpty(message = "性别不能为空")
    private int userSex = 0; // 0代表女 1代表男
    @ApiModelProperty(value = "电话号", required = true)
    @NotEmpty(message = "电话号不能为空")
    private String phoneNum;
    private Date creatTime;
    private int userAge;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String passWord;
}
