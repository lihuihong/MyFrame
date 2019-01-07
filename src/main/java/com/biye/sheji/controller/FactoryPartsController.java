package com.biye.sheji.controller;

import com.biye.sheji.entity.FactoryEqu;
import com.biye.sheji.entity.FactoryParts;
import com.biye.sheji.entity.Result;
import com.biye.sheji.entity.RspDataVo;
import com.biye.sheji.service.FactoryEquService;
import com.biye.sheji.service.FactoryPartsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/parts")
public class FactoryPartsController {

    @Autowired
    private FactoryPartsService factoryPartsService;
    @Autowired
    private FactoryEquService factoryEquService;

    /**
     * 获取全部设备配件信息
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result list(){
        List<FactoryParts> list = factoryPartsService.list();

        for (FactoryParts factoryParts : list) {
            factoryParts.setEquName(factoryEquService.selectByPrimaryKey(factoryParts.getEquId()).getEquName());
        }
        PageInfo<FactoryParts> pageInfo = new PageInfo<>(list);
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
     * 根据主键删除设备配件信息
     * @param equId
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Result delete(int equId){
        Result result = new Result();
        int i = factoryPartsService.deleteByPrimaryKey(equId);
        if (i!=0){
            result.setSuccessMsg("删除成功");
        }else {
            result.setErrorMsg("删除失败");
        }
        return result;
    }

    /**
     * 根据主键更新或增加配件信息
     * @param factoryParts
     * @return
     */
    @RequestMapping(value = "/Edit",method = RequestMethod.POST)
    public Result equEdit(FactoryParts factoryParts){
        //获取
        Result result = new Result();

        int resultTotal = 0;
        if(factoryParts.getPaetsId()==null){
            resultTotal=factoryPartsService.insert(factoryParts);
        }else{
            resultTotal=factoryPartsService.updateByPrimaryKeySelective(factoryParts);
        }

        if(resultTotal>0){
            result.setSuccessMsg("成功");
        }else{
            result.setErrorMsg("失败");
        }
        return result;
    }
}
