package com.tmall.auth.admin.controller.req;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginReq {

    @ApiModelProperty(value = "用户名", required = false)
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String passWord;
    @ApiModelProperty(value = "电话号", required = false)
    @NotEmpty(message = "用户名不能为空")
    private String phoneNum;

}
