package com.toutiao.dao;

import com.toutiao.pojo.Link;

public interface LinkMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(Link record);

    int insertSelective(Link record);

    Link selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);
}