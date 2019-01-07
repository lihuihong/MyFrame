package com.biye.sheji.service;

import com.biye.sheji.entity.Role;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有权限
     * @param role
     * @return
     */
    public List<Role> list(Role role);

    /**
     * 针对id查询所有权限
     * @param id
     * @return
     */
    public Role findById(Integer id);


     /**
     * 用户注册
     * @param role
     * @return
     */
    public Integer add(Role role);

    /**
     * 修改用户
     * @param role
     * @return
     */
    public Integer update(Role role);

    /**
     * 删除用户
     * @param id
     * @return
     *//*
    public Integer delete(Integer id);*/
}
