package com.tmall.auth.admin.feign;



import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfo {

    private String name;

    private AgeInfo ageInfo;

}
