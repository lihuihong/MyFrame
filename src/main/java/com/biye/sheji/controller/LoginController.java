package com.biye.sheji.controller;

import com.biye.sheji.entity.FactoryUser;
import com.biye.sheji.entity.PageBean;
import com.biye.sheji.entity.Result;
import com.biye.sheji.entity.Role;
import com.biye.sheji.service.FactoryUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户操作
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private FactoryUserService userService;

    /**
     * 用户登录
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Result login(FactoryUser user, HttpServletRequest request){

        Result result = new Result();
        FactoryUser resultUser = userService.login(user);
        if(resultUser==null){
            result.setErrorMsg("用户名或密码错误！");
        }else{
            result.setSuccessMsg("登录成功！");
            HttpSession session=request.getSession();
            session.setAttribute("userInfo",resultUser);
        }
        return result;
    }

    /**
     * 用户登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryUser")
    @ResponseBody
    public Result queryUser(HttpServletRequest request){

        Result result = new Result();
        FactoryUser resultUser = (FactoryUser) request.getSession().getAttribute("userInfo");
        if(resultUser==null){
            result.setErrorMsg("访问出错");
        }else{
            result.setSuccessMsg("成功！");
            result.setData(resultUser);
        }
        return result;
    }

    /**
     * 用户注册
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public Result register(FactoryUser user, HttpServletRequest request){

        Result result = new Result();
        FactoryUser resultUser = userService.login(user);
        if(resultUser==null){
            //默认注册账户为普通用户
            Role role = new Role();
            role.setId(2);
            user.setRole(role);
            int num = userService.add(user);
            if(num > 0){
                result.setSuccessMsg("注册成功!");
            }else{
                result.setErrorMsg("注册失败！");
            }
        }else{
            result.setErrorMsg("用户已经存在！");
        }

        return result;
    }

    /**
     * 查询所有用户信息
     * @param page
     * @param limit
     * @param s_user
     * @param response
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result list(Integer page, Integer limit , FactoryUser s_user,
                       HttpServletResponse response)throws Exception{

        PageBean pageBean = new PageBean(page,limit);
        List<FactoryUser> customerList = userService.list(s_user);
        PageInfo<FactoryUser> pageInfo = new PageInfo<>(customerList);

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
     * 添加或修改用户
     * @param s_user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public Result save(FactoryUser s_user, HttpServletRequest request, HttpServletResponse response)throws Exception{

        Result result = new Result();
        int resultTotal = 0;
        if(s_user.getId()==null){
            resultTotal=userService.add(s_user);
        }else{
            resultTotal=userService.update(s_user);

            request.getSession().setAttribute("userInfo",s_user);
        }

        if(resultTotal>0){
            result.setSuccessMsg("成功");
        }else{
            result.setErrorMsg("失败");
        }

        return result;
    }

    /**
     * 修改密码
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updatePwd")
    @ResponseBody
    public Result updatePwd(HttpServletRequest request, HttpServletResponse response)throws Exception{


        FactoryUser resultUser = (FactoryUser) request.getSession().getAttribute("userInfo");

        String password = resultUser.getPassword();

        String password1 = request.getParameter("password1");


        Result result = new Result();

        if(!(password.equals(password1))){
            result.setErrorMsg("原密码不正确");
        }else{

            password = request.getParameter("password3");
            resultUser.setPassword(password);

            userService.update(resultUser);

        }


        return result;


    }

    /**
     * 删除用户
     * @param id
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(Integer id, HttpServletResponse response)throws Exception{

        Integer num = userService.delete(id);

        Result result = new Result();

        if(num>0){
            result.setSuccessMsg("成功");
        }else{
            result.setErrorMsg("失败");
        }

        return result;
    }

    /**
     * 修改用户密码
     * @param s_user
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/modifyPassword")
    @ResponseBody
    public Result modifyPassword(FactoryUser s_user, HttpServletResponse response) throws Exception{

        int resultTotal = userService.update(s_user);

        Result result = new Result();

        if(resultTotal>0){
            result.setSuccessMsg("成功");
        }else{
            result.setErrorMsg("失败");
        }

        return result;
    }

    /**
     * 退出登录
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Result logout(HttpSession session)throws Exception{
        session.invalidate();
        Result result = new Result();
        result.setSuccessMsg("成功");
        return result;
    }



}
