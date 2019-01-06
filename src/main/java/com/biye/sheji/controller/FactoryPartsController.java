package com.biye.sheji.controller;

import com.biye.sheji.entity.FactoryParts;
import com.biye.sheji.entity.Result;
import com.biye.sheji.entity.RspDataVo;
import com.biye.sheji.service.FactoryPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 设备配件
 */
@Controller
@RequestMapping("/parts")
public class FactoryPartsController {

    @Autowired
    private FactoryPartsService factoryPartsService;

    /**
     * 获取全部设备配件信息
     * @return
     */
    @RequestMapping(value = "/list.action",method = RequestMethod.GET)
    public RspDataVo<FactoryParts> list(){
        RspDataVo<FactoryParts> rspDataVo = new RspDataVo<>();
        List<FactoryParts> list = factoryPartsService.list();
        rspDataVo.setCount(list.size());
        rspDataVo.setData(list);
        return rspDataVo;
    }

    /**
     * 根据主键删除设备配件信息
     * @param equId
     * @return
     */
    @RequestMapping(value = "/del.json",method = RequestMethod.POST)
    public Result delete(int equId){
        int i = factoryPartsService.deleteByPrimaryKey(equId);
        if (i!=0){
            return Result.success();
        }else {
            return Result.error("删除失败");
        }
    }

    /**
     * 根据主键更新设备配件信息
     * @param factoryParts
     * @return
     */
    @RequestMapping(value = "/equEdit.json",method = RequestMethod.POST)
    public Result equEdit(FactoryParts factoryParts){
        int i = factoryPartsService.updateByPrimaryKeySelective(factoryParts);
        if (i!=0){
            return Result.success();
        }else {
            return Result.error("修改失败");
        }
    }

    /**
     * 新增设备配件信息
     * @param factoryParts
     * @return
     */
    @RequestMapping(value = "/equSave.json",method = RequestMethod.POST)
    public Result equSave(FactoryParts factoryParts){
        int insert = factoryPartsService.insert(factoryParts);
        if (insert!=0){
            return Result.success();
        }else {
            return Result.error("保存失败");
        }
    }

}
