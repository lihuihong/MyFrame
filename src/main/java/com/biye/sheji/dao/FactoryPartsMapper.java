package com.biye.sheji.dao;

import com.biye.sheji.entity.FactoryParts;

import java.util.List;

public interface FactoryPartsMapper {
    /**
     * 通过主键删除设备配件信息
     * @param paetsId
     * @return
     */
    int deleteByPrimaryKey(Integer paetsId);

    /**
     * 新增设备配件
     * @param record
     * @return
     */
    int insert(FactoryParts record);

    int insertSelective(FactoryParts record);

    /**
     * 通过主键获取设备配件信息
     * @param paetsId
     * @return
     */
    FactoryParts selectByPrimaryKey(Integer paetsId);

    /**
     *查询全部设备信息
     * @return
     */
    List<FactoryParts> list();

    /**
     * 通过主键更新设备配件信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FactoryParts record);

    int updateByPrimaryKey(FactoryParts record);
}
