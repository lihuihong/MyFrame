package com.biye.sheji.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;
import java.util.*;

@Controller
@RequestMapping("/web")
public class MainController {


	/**
     * 登录界面跳转
     */
    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    public String to_login(HttpServletRequest request){
        return "/login";
    }
    /**
     * 注册界面跳转
     */
    @RequestMapping(value = "/register.action" ,method = RequestMethod.GET)
    public String to_register(HttpServletRequest request){
        return "/register";
    }

    /**
     * 修改密码界面跳转
     */
    @RequestMapping(value = "/password.action" ,method = RequestMethod.GET)
    public String password(HttpServletRequest request){
        return "/updatePassword";
    }

    /**
     * 主页面跳转
     */
    @RequestMapping(value = "/index.action",method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        return "/main";
    }

    /**
     * 用户管理
     */
    @RequestMapping(value = "/userManage.action",method = RequestMethod.GET)
    public String userManage(HttpServletRequest request){
        return "/userManage";
    }

    /**
     * 单纯的页面跳转
     *
     * @param name
     *            页面名称，即jsp文件名
     * @return
     */
    @RequestMapping(value = "/equ/{name}.action", method = RequestMethod.GET)
    public String page(@PathVariable String name) {
        return "/from"+name;
    }


}
