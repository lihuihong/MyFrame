package com.biye.sheji.service.impl;

import com.biye.sheji.dao.FactoryRepairMapper;
import com.biye.sheji.entity.FactoryEqu;
import com.biye.sheji.entity.FactoryRepair;
import com.biye.sheji.service.FactoryRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FactoryRepairImpl implements FactoryRepairService {

    @Autowired
    private FactoryRepairMapper factoryRepairMapper;

    @Override
    public int deleteByPrimaryKey(Integer equId) {
        return factoryRepairMapper.deleteByPrimaryKey(equId);
    }

    @Override
    public int insert(FactoryRepair record) {
        return factoryRepairMapper.insert(record);
    }

    @Override
    public int insertSelective(FactoryRepair record) {
        return factoryRepairMapper.insertSelective(record);
    }

    @Override
    public FactoryRepair selectByPrimaryKey(Integer equId) {
        return factoryRepairMapper.selectByPrimaryKey(equId);
    }

    @Override
    public int updateByPrimaryKeySelective(FactoryRepair record) {
        return factoryRepairMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FactoryRepair record) {
        return factoryRepairMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FactoryRepair> list() {
        return factoryRepairMapper.list();
    }
}
