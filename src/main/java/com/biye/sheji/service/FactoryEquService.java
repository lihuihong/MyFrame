package com.biye.sheji.service;

import com.biye.sheji.dao.FactoryEquMapper;
import com.biye.sheji.entity.FactoryEqu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryEquService {
    @Autowired
    private FactoryEquMapper factoryEquMapper;

    /**
     * 查询所有设备
     * @return
     */
    public List<FactoryEqu> list(){
        List<FactoryEqu> list = factoryEquMapper.list();
        return list;
    }

    /**
     * 根据主键获取设备信息
     * @param equId
     * @return
     */
    public FactoryEqu selectByPrimaryKey(int equId){
       return factoryEquMapper.selectByPrimaryKey(equId);
    }

    /**
     * 根据主键删除设备信息
     * @param equId
     * @return
     */
    public int deleteByPrimaryKey(int equId){
        return factoryEquMapper.deleteByPrimaryKey(equId);
    }

    /**
     * 根据主键更新设备信息
     * @param record
     * @return
     */
    public  int updateByPrimaryKeySelective(FactoryEqu record) {
        return factoryEquMapper.updateByPrimaryKeySelective(record);

    }

    /**
     * 新增设备信息
     * @param factoryEqu
     * @return
     */
    public int insert(FactoryEqu factoryEqu){
        return factoryEquMapper.insert(factoryEqu);
    }


}
