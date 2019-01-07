package com.biye.sheji.service.impl;

import com.biye.sheji.dao.FactoryUserMapper;
import com.biye.sheji.entity.FactoryUser;
import com.biye.sheji.service.FactoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class FactoryUserServiceImpl implements FactoryUserService {

    @Autowired
    private FactoryUserMapper factoryUserMapper;
    @Override
    public FactoryUser login(FactoryUser user) {
        return factoryUserMapper.login(user);
    }

    @Override
    public List<FactoryUser> list(FactoryUser user) {
        return factoryUserMapper.list(user);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return factoryUserMapper.getTotal(map);
    }

    @Override
    public Integer add(FactoryUser user) {
        return factoryUserMapper.add(user);
    }

    @Override
    public Integer update(FactoryUser user) {
        return factoryUserMapper.update(user);
    }

    @Override
    public Integer delete(Integer id) {
        return factoryUserMapper.delete(id);
    }

    @Override
    public FactoryUser queryUserByUid(Integer id) {
        return factoryUserMapper.queryUserByUid(id);
    }
}
