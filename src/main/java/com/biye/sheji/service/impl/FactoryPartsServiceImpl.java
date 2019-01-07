package com.biye.sheji.service.impl;

import com.biye.sheji.dao.FactoryPartsMapper;
import com.biye.sheji.entity.FactoryEqu;
import com.biye.sheji.entity.FactoryParts;
import com.biye.sheji.service.FactoryPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FactoryPartsServiceImpl implements FactoryPartsService {

    @Autowired
    private FactoryPartsMapper factoryPartsMapper;

    @Override
    public int deleteByPrimaryKey(Integer equId) {
        return factoryPartsMapper.deleteByPrimaryKey(equId);
    }

    @Override
    public int insert(FactoryParts record) {
        return factoryPartsMapper.insert(record);
    }

    @Override
    public int insertSelective(FactoryParts record) {
        return factoryPartsMapper.insertSelective(record);
    }

    @Override
    public FactoryParts selectByPrimaryKey(Integer equId) {
        return factoryPartsMapper.selectByPrimaryKey(equId);
    }

    @Override
    public int updateByPrimaryKeySelective(FactoryParts record) {
        return factoryPartsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FactoryParts record) {
        return factoryPartsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FactoryParts> list() {
        return factoryPartsMapper.list();
    }
}
