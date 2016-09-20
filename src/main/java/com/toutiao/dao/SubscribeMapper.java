package com.toutiao.dao;

import com.toutiao.pojo.Subscribe;

public interface SubscribeMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Subscribe record);

    int insertSelective(Subscribe record);

    Subscribe selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Subscribe record);

    int updateByPrimaryKey(Subscribe record);
}