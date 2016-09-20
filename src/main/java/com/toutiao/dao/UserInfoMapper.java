package com.toutiao.dao;

import com.toutiao.pojo.UserInfo;
import com.toutiao.pojo.UserInfoWithBLOBs;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserInfoWithBLOBs record);

    int insertSelective(UserInfoWithBLOBs record);

    UserInfoWithBLOBs selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserInfoWithBLOBs record);

    int updateByPrimaryKey(UserInfo record);
}