package com.biye.sheji.service.impl;

import com.biye.sheji.dao.FunDao;
import com.biye.sheji.entity.Fun;
import com.biye.sheji.service.FunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunServiceImpl implements FunService {

    @Autowired
    private FunDao funDao;

    @Override
    public List<Fun> list() {
        return funDao.list();
    }


}