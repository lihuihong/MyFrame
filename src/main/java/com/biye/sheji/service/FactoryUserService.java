package com.biye.sheji.service;

import com.biye.sheji.dao.FactoryUserMapper;
import com.biye.sheji.entity.FactoryUser;
import com.biye.sheji.exception.LException;
import com.biye.sheji.util.Jiami;
import com.biye.sheji.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("FactoryUserService")
public class FactoryUserService {

    @Autowired
    private FactoryUserMapper factoryUserMapper;

    /**
     * 用户登录
     *
     * @param request
     * @return
     * @throws LException
     */
    public Map<String, Object> selectUser(HttpServletRequest request) throws LException {
        //获取登录参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //校验用户名、密码是否正确
        FactoryUser user = selectUser(username, MD5.md5(password));
        if (user == null) {
            throw new LException("账号或密码错误");
        }

        //将用户信息保存进session
        request.getSession().setAttribute("userInfo", user);
        //对用户信息进行加密，用于cookie存储
        // 用户的登录名和密码
        String userToken = Jiami.getInstance().encrypt(username) + "&&" + Jiami.getInstance().encrypt(password);
        // 将用户名转为没有特殊字符的base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        userToken = encoder.encode(userToken.getBytes());

        Map<String, Object> info = new HashMap<String, Object>();
        info.put("userToken", userToken);
        return info;
    }

    /**
     * 校验用户登录
     *
     * @param username 登录名
     * @param password 登录密码
     * @return
     */
    public FactoryUser selectUser(String username, String password) {
        return factoryUserMapper.checkUser(username, password);
    }

    /**
     * 用户注册
     *
     * @param request
     * @return
     */
    public Map<String, Object> regist(HttpServletRequest request) {
        //获取注册参数
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");
        FactoryUser factoryUser = new FactoryUser();
        factoryUser.setUserUsername(username);
        factoryUser.setUserPassword(MD5.md5(password));
        //设置用户类型（0，普通用户 1，管理员用户）
        factoryUser.setUserType(0);
        factoryUserMapper.insertSelective(factoryUser);
        // 对用户信息进行加密，用于cookie存储
        // 用户的登录名和密码
        String userToken = Jiami.getInstance().encrypt(username) + "&&" + Jiami.getInstance().encrypt(password);
        // 将用户名转为没有特殊字符的base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        userToken = encoder.encode(userToken.getBytes());

        Map<String, Object> info = new HashMap<String, Object>();
        info.put("userToken", userToken);
        return info;
    }

    /**
     * 用户修改密码
     *
     */
    public void updateNewPassword(HttpServletRequest request) throws LException {

        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");
        String oldPassword = request.getParameter("oldPassword");

        //得到当前用户登录的id
        String userId = String.valueOf(request.getSession().getAttribute("user"));
        if (oldPassword == null && oldPassword == "") {
            throw new LException("输入旧密码不能为空");
        }
        if (newPassword1 == null && newPassword1 == "") {
            throw new LException("输入新密码不能为空");
        }
        if (newPassword2 == null && newPassword2 == "") {
            throw new LException("再次输入新密码不能为空");
        }
        // 从session中取用户信息
        // 判断session
        HttpSession session = request.getSession();
        // 从session中取出用户身份信息
        FactoryUser user1 = (FactoryUser) session.getAttribute("userInfo");
        //根据旧密码，判断查询用户
        FactoryUser user = factoryUserMapper.selectByPassword(MD5.md5(oldPassword), user1.getUserId());
        if (user == null) {
            throw new LException("旧密码错误");
        }
        //校验新密码
        newPassword1 = newPassword1.replaceAll("\\s*", "");
        if (newPassword1.length() < 6 || newPassword1.length() > 16) {
            throw new LException("密码长度应为6到16个字符");
        }
        //校验新密码两次输入是否一致
        if (!newPassword1.equals(newPassword2)) {
            throw new LException("两次新密码不一致");
        }
        //更新新密码
        user.setUserUsername(MD5.md5(newPassword1));
        user.setUserId(Integer.valueOf(userId));
        factoryUserMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 根据用户id查询信息
     *
     * @param id
     * @return
     */
    public FactoryUser selectById(int id) {
        return factoryUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<FactoryUser> selectAllFactoryUser(){
        List<FactoryUser> factoryUsers = factoryUserMapper.selectAllFactoryUser();
        return factoryUsers;
    }

    /**
     * 根据用户id修改用户信息
     * @return
     */
    public int updateByPrimaryKeySelective(FactoryUser factoryUser){
        return factoryUserMapper.updateByPrimaryKeySelective(factoryUser);
    }

    /**
     * 根据主键删除用户
     * @param userId
     * @return
     */
    public int deleteByPrimaryKey(Integer userId){
        return factoryUserMapper.deleteByPrimaryKey(userId);
    }
}
