package com.toutiao.dao;

import com.toutiao.pojo.Exclusive;

public interface ExclusiveMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(Exclusive record);

    int insertSelective(Exclusive record);

    Exclusive selectByPrimaryKey(Integer eid);

    int updateByPrimaryKeySelective(Exclusive record);

    int updateByPrimaryKey(Exclusive record);
}