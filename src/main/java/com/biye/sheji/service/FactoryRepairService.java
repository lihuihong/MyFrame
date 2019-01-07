package com.biye.sheji.service;

import com.biye.sheji.entity.FactoryRepair;

import java.util.List;

public interface FactoryRepairService {
    /**
     * 根据主键删除维修信息
     * @param repairId
     * @return
     */
    int deleteByPrimaryKey(Integer repairId);

    /**
     * 新增维修信息
     * @param record
     * @return
     */
    int insert(FactoryRepair record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(FactoryRepair record);

    /**
     * 根据主键查询维修信息
     * @param repairId
     * @return
     */
    FactoryRepair selectByPrimaryKey(Integer repairId);
    List<FactoryRepair> list();

    /**
     * 根据主键更新维修信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FactoryRepair record);

    int updateByPrimaryKey(FactoryRepair record);
}
