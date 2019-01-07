package com.biye.sheji.controller;

import com.biye.sheji.entity.FactoryParts;
import com.biye.sheji.entity.FactoryRepair;
import com.biye.sheji.entity.Result;
import com.biye.sheji.service.FactoryEquService;
import com.biye.sheji.service.FactoryPartsService;
import com.biye.sheji.service.FactoryRepairService;
import com.biye.sheji.service.FactoryUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/repair")
public class FactoryRepairController {

    @Autowired
    private FactoryRepairService factoryRepairService;
    @Autowired
    private FactoryUserService factoryUserService;
    @Autowired
    private FactoryEquService factoryEquService;
    @Autowired
    private FactoryPartsService factoryPartsService;

    /**
     * 获取全部设备维修
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result list(){
        List<FactoryRepair> list = factoryRepairService.list();
        for (FactoryRepair factoryRepair : list) {
            factoryRepair.setUserName(factoryUserService.queryUserByUid(factoryRepair.getUserId()).getUserName());
            factoryRepair.setEquName(factoryEquService.selectByPrimaryKey(factoryRepair.getEquId()).getEquName());
            factoryRepair.setPaetsName(factoryPartsService.selectByPrimaryKey(factoryRepair.getPaetsId()).getPaetsName());
        }
        PageInfo<FactoryRepair> pageInfo = new PageInfo<>(list);
        Result result = new Result();

        if(pageInfo.getTotal() > 0){
            result.setSuccessMsg("获取成功");
            result.setData(pageInfo.getList());
            result.setCount((int) pageInfo.getTotal());
        }else{
            result.setSuccessMsg("获取失败");
            result.setCount(0);
        }

        return result;
    }

    /**
     * 根据主键删除设备维修
     * @param equId
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Result delete(int equId){
        Result result = new Result();
        int i = factoryRepairService.deleteByPrimaryKey(equId);
        if (i!=0){
            result.setSuccessMsg("删除成功");
        }else {
            result.setErrorMsg("删除失败");
        }
        return result;
    }

    /**
     * 根据主键更新或增加设备维修
     * @param factoryRepair
     * @return
     */
    @RequestMapping(value = "/Edit",method = RequestMethod.POST)
    public Result equEdit(FactoryRepair factoryRepair){
        //获取
        Result result = new Result();

        int resultTotal = 0;
        if(factoryRepair.getPaetsId()==null){
            resultTotal=factoryRepairService.insert(factoryRepair);
        }else{
            resultTotal=factoryRepairService.updateByPrimaryKeySelective(factoryRepair);
        }

        if(resultTotal>0){
            result.setSuccessMsg("成功");
        }else{
            result.setErrorMsg("失败");
        }
        return result;
    }
}
