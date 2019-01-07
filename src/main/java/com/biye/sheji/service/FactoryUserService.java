package com.biye.sheji.service;

import com.biye.sheji.entity.FactoryUser;

import java.util.List;
import java.util.Map;

public interface FactoryUserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    public FactoryUser login(FactoryUser user);


    /**
     * 查询所有用户信息
     * @param user
     * @return
     */
    public List<FactoryUser> list(FactoryUser user);

    /**
     * 获取用户记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String, Object> map);

    /**
     * 用户注册
     * @param user
     * @return
     */
    public Integer add(FactoryUser user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public Integer update(FactoryUser user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public Integer delete(Integer id);


    /**
     * 根据用户id获取用户
     * @param id
     * @return
     */
    public FactoryUser queryUserByUid(Integer id);
}
