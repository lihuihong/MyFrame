package com.biye.sheji.controller;

import com.biye.sheji.entity.*;
import com.biye.sheji.service.FactoryEquService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/equ")
public class FactoryEquController {
    @Autowired
    private FactoryEquService factoryEquService;

    /**
     * 查询所有设备信息
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result list(Integer page, Integer limit ){
        List<FactoryEqu> list = factoryEquService.list();
        PageInfo<FactoryEqu> pageInfo = new PageInfo<>(list);
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
     * 根据主键删除设备信息
     * @param equId
     * @return
     */
    @RequestMapping(value = "/equDel")
    @ResponseBody
    public Result equDel(int equId){
        Result result = new Result();
        int i = factoryEquService.deleteByPrimaryKey(equId);
        if (i!=0){
            result.setSuccessMsg("删除成功");
        }else {
            result.setErrorMsg("删除失败");
        }
        return result;
    }

    /**
     * 根据主键更新或增加设备信息
     * @return
     */
    @RequestMapping(value = "/equEditOrSave")
    @ResponseBody
    public Result equEditOrSave(FactoryEqu factoryEqu,HttpServletRequest request){
        //获取
        Result result = new Result();

        int resultTotal = 0;
        if(factoryEqu.getEquId()==null){
            resultTotal=factoryEquService.insert(factoryEqu);
        }else{
            resultTotal=factoryEquService.updateByPrimaryKeySelective(factoryEqu);
        }

        if(resultTotal>0){
            result.setSuccessMsg("成功");
        }else{
            result.setErrorMsg("失败");
        }
        return result;
    }

}
