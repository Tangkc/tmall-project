package com.tmall.auth.admin.mapper;


import com.tmall.auth.admin.controller.req.LoginReq;
import com.tmall.auth.admin.mapper.dto.UserInfoDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    @Insert("INSERT INTO tmall_user (user_name, user_phone,user_sex,create_time,user_age,user_password,user_type) VALUES(#{userName}, #{phoneNum}, #{userSex}, now(),#{userAge},#{passWord}，#{userType})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUserInfo(UserInfoDto info);

    @Select("SELECT count(1) from tmall_user where user_phone = #{phoneNum}")
    int countUserInfo(String phoneNum);


    @Select({"<script>",
            " SELECT user_id as userId,user_name as userName,user_age as userAge ,user_sex as userSex ,user_phone as phoneNum ,create_time as creatTime ,user_password as passWord," +
                    "user_type as userType from tmall_user where user_password = #{passWord} " +
            "<if test=\"userName != null and userName != ''\">and user_name = #{userName}</if>"+
            "<if test=\"phoneNum != null and phoneNum != ''\">and user_phone = #{phoneNum}</if>"
            ,"</script>"})
    @ResultType(value = UserInfoDto.class)
    UserInfoDto getUserInfo(LoginReq loginReq);

}

