package com.biye.sheji.controller;

import com.biye.sheji.entity.FactoryUser;
import com.biye.sheji.entity.Result;
import com.biye.sheji.service.FactoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户操作
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private FactoryUserService factoryUserService;

    /**
     * 用户登录
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login.json",method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpServletRequest request) throws Exception {
        Map<String, Object> info = factoryUserService.selectUser(request);
        return Result.success().add("info", info);
    }
    /**
     * 用户注册
     * @throws Exception
     */
    @RequestMapping(value = "/register.json",method = RequestMethod.POST)
    @ResponseBody
    public Result show_register(HttpServletRequest request) throws Exception {
        Map<String, Object> info = factoryUserService.regist(request);
        return Result.success().add("info", info);
    }
    /**
     * 用户修改密码
     * @throws Exception
     */
    @RequestMapping(value = "/updateNewPassword.json",method = RequestMethod.POST)
    @ResponseBody
    public Result updateNewPassword(HttpServletRequest request) throws Exception {
        factoryUserService.updateNewPassword(request);
        return Result.success();
    }



}
