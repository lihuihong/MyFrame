package com.biye.sheji.service.impl;

import com.biye.sheji.dao.RoleDao;
import com.biye.sheji.entity.Role;
import com.biye.sheji.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> list(Role role) {
        return roleDao.list(role);
    }

    @Override
    public Role findById(Integer id) {
        return roleDao.findById(id);
    }

    @Override
    public Integer add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Integer update(Role role) {
        return roleDao.update(role);
    }

    /*@Override
    public Integer delete(Integer id) {
        return roleDao.delete(id);
    }*/
}