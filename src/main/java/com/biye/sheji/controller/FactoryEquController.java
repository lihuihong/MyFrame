package com.biye.sheji.controller;

import com.biye.sheji.entity.FactoryEqu;
import com.biye.sheji.entity.Result;
import com.biye.sheji.entity.RspDataVo;
import com.biye.sheji.service.FactoryEquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 设备管理
 */
@Controller
@RequestMapping("/equ")
public class FactoryEquController {

    @Autowired
    private FactoryEquService factoryEquService;

    /**
     * 查询所有设备信息
     * @return
     */
    @RequestMapping(value = "/list.action",method = RequestMethod.GET)
    public RspDataVo<FactoryEqu> list(){
        RspDataVo<FactoryEqu> rspDataVo = new RspDataVo<>();
        List<FactoryEqu> list = factoryEquService.list();
        rspDataVo.setCount(list.size());
        rspDataVo.setData(list);
        return rspDataVo;
    }

    /**
     * 根据主键删除设备信息
     * @param equId
     * @return
     */
    @RequestMapping(value = "/del.json",method = RequestMethod.POST)
    public Result delete(int equId){
        int i = factoryEquService.deleteByPrimaryKey(equId);
        if (i!=0){
            return Result.success();
        }else {
            return Result.error("删除失败");
        }
    }

    /**
     * 根据主键查询设备信息
     * @return
     */
    @RequestMapping(value = "/equEdit.action",method = RequestMethod.GET)
    public String equEdit(ModelMap map, HttpServletRequest request){
        //获取
        int id = Integer.parseInt(request.getParameter("id"));
        FactoryEqu factoryEqu = factoryEquService.selectByPrimaryKey(id);
        factoryEqu.setEquIspass(factoryEqu.getEquIspass() == "0"?"未报修":"已报修");
        factoryEqu.setEquIsok(factoryEqu.getEquIsok() == "0"?"未报废":"已报废");
        factoryEqu.setEquConsu(factoryEqu.getEquConsu() == "0"?"未报修":"已报修");
        map.put("data",factoryEqu);
        return "/from/equEdit";
    }
    /**
     * 根据主键更新设备信息
     * @param factoryEqu
     * @return
     */
    @RequestMapping(value = "/equEdit.json",method = RequestMethod.POST)
    public Result equEdit(FactoryEqu factoryEqu){
        int i = factoryEquService.updateByPrimaryKeySelective(factoryEqu);
        if (i!=0){
            return Result.success();
        }else {
            return Result.error("修改失败");
        }
    }

    /**
     * 新增设备信息
     * @param factoryEqu
     * @return
     */
    @RequestMapping(value = "/equSave.json",method = RequestMethod.POST)
    public Result equSave(FactoryEqu factoryEqu){
        int insert = factoryEquService.insert(factoryEqu);
        if (insert!=0){
            return Result.success();
        }else {
            return Result.error("保存失败");
        }
    }


}
