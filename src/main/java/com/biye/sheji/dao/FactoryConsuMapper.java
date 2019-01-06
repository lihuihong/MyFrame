package com.biye.sheji.dao;


import com.biye.sheji.entity.FactoryConsu;

public interface FactoryConsuMapper {

    int deleteByPrimaryKey(Integer consuId);

    int insert(FactoryConsu record);

    int insertSelective(FactoryConsu record);


    FactoryConsu selectByPrimaryKey(Integer consuId);



    int updateByPrimaryKeySelective(FactoryConsu record);

    int updateByPrimaryKey(FactoryConsu record);
}