package com.example.core.user.controller;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfo {

    private String name;

    private AgeInfo ageInfo;

}
