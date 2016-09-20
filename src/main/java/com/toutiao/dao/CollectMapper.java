package com.toutiao.dao;

import com.toutiao.pojo.Collect;

public interface CollectMapper {
    int insert(Collect record);

    int insertSelective(Collect record);
}