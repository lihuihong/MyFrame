package com.biye.sheji.dao;

import com.biye.sheji.entity.FactoryUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FactoryUserMapper {

    /**
     * 根据主键删除用户信息
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入用户信息
     * @param factoryUser
     * @return
     */
    int insert(FactoryUser factoryUser);

    int insertSelective(FactoryUser record);

    /**
     * 根据主键查询用户信息
     * @param userId
     * @return
     */
    FactoryUser selectByPrimaryKey(Integer userId);

    /**
     * 根据用户id修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FactoryUser record);

    int updateByPrimaryKey(FactoryUser record);
    /**
     * 校验用户
     * @param userName 登录名
     * @param passWord 登录密码
     * @return
     */
    FactoryUser checkUser(@Param("userName") String userName, @Param("passWord") String passWord);
    /**
     * 根据旧密码，判断查询用户
     * @param password
     * @return
     */
    FactoryUser selectByPassword(@Param("password") String password, @Param("id") int id);

    /**
     * 根据用户id查询信息
     * @param id
     * @return
     */
    FactoryUser selectById(int id);

    List<FactoryUser> selectAllFactoryUser();
}