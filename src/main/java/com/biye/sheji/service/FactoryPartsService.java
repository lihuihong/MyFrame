package com.biye.sheji.service;

import com.biye.sheji.dao.FactoryPartsMapper;
import com.biye.sheji.entity.FactoryParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryPartsService {

    @Autowired
    private FactoryPartsMapper factoryPartsMapper;



    /**
     * 通过主键获取设备配件信息
     * @param paetsId
     * @return
     */
    public FactoryParts selectByPrimaryKey(int paetsId){
        return factoryPartsMapper.selectByPrimaryKey(paetsId);
    }

    /**
     * 新增设备配件
     * @param factoryParts
     * @return
     */
    public int insert(FactoryParts factoryParts){
        return factoryPartsMapper.insert(factoryParts);
    }

    /**
     * 通过主键删除设备配件信息
     * @param paetsId
     * @return
     */
    public int deleteByPrimaryKey(Integer paetsId){
        return factoryPartsMapper.deleteByPrimaryKey(paetsId);
    }

    /**
     * 通过主键更新设备配件信息
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(FactoryParts record){
        return factoryPartsMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 获取全部设备配件信息
     * @return
     */
    public List<FactoryParts> list(){
        return factoryPartsMapper.list();
    }



}
