package com.biye.sheji.controller;

import com.biye.sheji.dao.FactoryRepairMapper;
import com.biye.sheji.entity.FactoryParts;
import com.biye.sheji.entity.FactoryRepair;
import com.biye.sheji.entity.Result;
import com.biye.sheji.entity.RspDataVo;
import com.biye.sheji.service.FactoryRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 设备维修
 */
@Controller
@RequestMapping("/repair")
public class FactoryRepairController {
    
    @Autowired
    private FactoryRepairService factoryRepairService;


    /**
     * 获取全部设备维修信息
     * @return
     */
    @RequestMapping(value = "/list.action",method = RequestMethod.GET)
    public RspDataVo<FactoryRepair> list(){
        RspDataVo<FactoryRepair> rspDataVo = new RspDataVo<>();
        List<FactoryRepair> list = factoryRepairService.list();
        rspDataVo.setCount(list.size());
        rspDataVo.setData(list);
        return rspDataVo;
    }

    /**
     * 根据主键删除设备维修信息
     * @param equId
     * @return
     */
    @RequestMapping(value = "/del.json",method = RequestMethod.POST)
    public Result delete(int equId){
        int i = factoryRepairService.deleteByPrimaryKey(equId);
        if (i!=0){
            return Result.success();
        }else {
            return Result.error("删除失败");
        }
    }

    /**
     * 根据主键更新设备维修信息
     * @param factoryRepair
     * @return
     */
    @RequestMapping(value = "/equEdit.json",method = RequestMethod.POST)
    public Result equEdit(FactoryRepair factoryRepair){
        int i = factoryRepairService.updateByPrimaryKeySelective(factoryRepair);
        if (i!=0){
            return Result.success();
        }else {
            return Result.error("修改失败");
        }
    }

    /**
     * 新增设备维修信息
     * @param factoryRepair
     * @return
     */
    @RequestMapping(value = "/equSave.json",method = RequestMethod.POST)
    public Result equSave(FactoryRepair factoryRepair){
        int insert = factoryRepairService.insert(factoryRepair);
        if (insert!=0){
            return Result.success();
        }else {
            return Result.error("保存失败");
        }
    }
}
