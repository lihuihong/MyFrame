package com.biye.sheji.controller;


import com.biye.sheji.entity.FactoryUser;
import com.biye.sheji.entity.Fun;
import com.biye.sheji.entity.Role;
import com.biye.sheji.service.FunService;
import com.biye.sheji.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web")
public class MainController {

    public static final int WIDTH = 80;// 生成的图片的宽度
    public static final int HEIGHT = 25;// 生成的图片的高度

    @Autowired
    private RoleService roleServiceImp;
    @Autowired
    private FunService funServiceImp;

    /**
     * 跳转到主页面
     *
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/main")
    public String main(HttpSession session, HttpServletRequest request) {

        FactoryUser admin = (FactoryUser) session.getAttribute("userInfo");

        Map<String, List<Fun>> roles = new LinkedHashMap<>();
        List<String> icons = new ArrayList<>();

        // 获取用户角色信息
        Role role  = roleServiceImp.findById(admin.getRoleId());
        String funstr = role.getFuns();
        List<String> funs = Arrays.asList(funstr.split(","));
        // 获取所有模块和功能
        List<Fun> modAndFuns = funServiceImp.list();

        // 获取所有模块
        List<Fun> mods = modAndFuns.stream().filter(t -> t.getPid().equals(0)).collect(Collectors.toList());
        // 便利模块
        for (Fun mod : mods) {
            // 获取该模块下用户拥有的所有功能
            icons.add(mod.getIcon());
            List<Fun> functions = modAndFuns.stream()
                    .filter(t -> t.getPid().equals(mod.getId()) && funs.contains("" + t.getId()))
                    .collect(Collectors.toList());
            if (functions.size() > 0) {
                roles.put(mod.getName(), functions);
            }
        }
        request.setAttribute("roles", roles);
        request.setAttribute("icons", icons);
        request.setAttribute("admin", admin);
        return "/main";
    }




    /**
     * 单纯的页面跳转
     *
     * @param name
     *            页面名称，即jsp文件名
     * @return
     */
    @RequestMapping(value = "/page/{name}", method = RequestMethod.GET)
    public String page(@PathVariable String name) {
        return name;
    }

    /**
     * 单纯的页面跳转
     *
     * 页面名称，即jsp文件名
     *
     * @return
     */
    @RequestMapping(value = "/page/{model}/{fun}", method = RequestMethod.GET)
    public String page(@PathVariable String model, @PathVariable String fun) {
        return model + "/" + fun;
    }

    /**
     * 单纯的页面跳转
     *
     * 页面名称，即jsp文件名
     *
     * @return
     */
    @RequestMapping(value = "/page/{model}/{fun}/{file}", method = RequestMethod.GET)
    public String page(@PathVariable String model, @PathVariable String fun, @PathVariable String file) {
        return model + "/" + fun + "/" + file;
    }

}

