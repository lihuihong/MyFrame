package com.biye.sheji.service.impl;

import com.biye.sheji.dao.FactoryEquMapper;
import com.biye.sheji.entity.FactoryEqu;
import com.biye.sheji.service.FactoryEquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FactoryEquServiceImpl implements FactoryEquService {

    @Autowired
    private FactoryEquMapper factoryEquMapper;

    @Override
    public int deleteByPrimaryKey(Integer equId) {
        return factoryEquMapper.deleteByPrimaryKey(equId);
    }

    @Override
    public int insert(FactoryEqu record) {
        return factoryEquMapper.insert(record);
    }

    @Override
    public int insertSelective(FactoryEqu record) {
        return factoryEquMapper.insertSelective(record);
    }

    @Override
    public FactoryEqu selectByPrimaryKey(Integer equId) {
        return factoryEquMapper.selectByPrimaryKey(equId);
    }

    @Override
    public int updateByPrimaryKeySelective(FactoryEqu record) {
        return factoryEquMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FactoryEqu record) {
        return factoryEquMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FactoryEqu> list() {
        return factoryEquMapper.list();
    }
}
