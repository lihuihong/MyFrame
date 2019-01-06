package com.biye.sheji.dao;


import com.biye.sheji.entity.FactoryEqu;

import java.util.List;

public interface FactoryEquMapper {


    /**
     * 根据主键删除设备信息
     * @param equId
     * @return
     */
    int deleteByPrimaryKey(Integer equId);

    int insert(FactoryEqu record);

    int insertSelective(FactoryEqu record);


    /**
     * 根据主键获取设备信息
     * @param equId
     * @return
     */
    FactoryEqu selectByPrimaryKey(Integer equId);

    /**
     * 根据主键更新设备信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FactoryEqu record);

    int updateByPrimaryKey(FactoryEqu record);


    /**
     * 查询所有设备
     * @return
     */
    List<FactoryEqu> list();
}