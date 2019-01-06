package com.biye.sheji.controller;

import com.biye.sheji.dao.FactoryUserMapper;
import com.biye.sheji.entity.FactoryUser;
import com.biye.sheji.entity.Result;
import com.biye.sheji.entity.RspDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userInfo")
public class FactoryUserController {

    @Autowired
    private FactoryUserMapper factoryUserMapper;

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/index.action")
    @ResponseBody
    public RspDataVo<FactoryUser> index(HttpServletRequest request) {
        RspDataVo<FactoryUser> factoryUserRspDataVo = new RspDataVo<FactoryUser>();
        List<FactoryUser> list = factoryUserMapper.selectAllFactoryUser();
        factoryUserRspDataVo.setCount(list.size());
        factoryUserRspDataVo.setData(list);
        return factoryUserRspDataVo;
    }

    /**
     * 修改该用户信息
     *
     * @return
     */
    @RequestMapping("/userEdit.json")
    @ResponseBody
    public Result userEdit(FactoryUser cardUser) {
        int i = factoryUserMapper.updateByPrimaryKeySelective(cardUser);
        if (i!=0){
            return Result.success();
        }else {
            return Result.error("修改失败");
        }
    }

    /**
     * 根据用户主键删除用户
     * @param userId
     * @return
     */
    @RequestMapping("/userDelete.json")
    @ResponseBody
    public Result userDelete(Integer userId) {
        int i = factoryUserMapper.deleteByPrimaryKey(userId);
        if (i!=0){
            return Result.success();
        }else {
            return Result.error("删除失败");
        }
    }
}
