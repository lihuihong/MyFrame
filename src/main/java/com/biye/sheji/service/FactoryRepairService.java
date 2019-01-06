package com.biye.sheji.service;

import com.biye.sheji.dao.FactoryRepairMapper;
import com.biye.sheji.entity.FactoryRepair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryRepairService {
    @Autowired
    private FactoryRepairMapper factoryRepairMapper;

    /**
     * 通过主键获取设备维修信息
     * @param paetsId
     * @return
     */
    public FactoryRepair selectByPrimaryKey(int paetsId){
        return factoryRepairMapper.selectByPrimaryKey(paetsId);
    }

    /**
     * 新增设备维修
     * @param factoryParts
     * @return
     */
    public int insert(FactoryRepair factoryParts){
        return factoryRepairMapper.insert(factoryParts);
    }

    /**
     * 通过主键删除设备维修信息
     * @param paetsId
     * @return
     */
    public int deleteByPrimaryKey(Integer paetsId){
        return factoryRepairMapper.deleteByPrimaryKey(paetsId);
    }

    /**
     * 通过主键更新设备维修信息
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(FactoryRepair record){
        return factoryRepairMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 获取全部设备维修信息
     * @return
     */
    public List<FactoryRepair> list(){
        return factoryRepairMapper.list();
    }
}
