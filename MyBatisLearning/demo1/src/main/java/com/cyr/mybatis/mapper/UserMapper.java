package com.cyr.mybatis.mapper;

import com.cyr.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改
     */
    int updateUser();

    /**
     * 删除
     * @return
     */
    int deleteUser();

    /**
     *查询一个实体类对象
     */
    User getUserbyId();

    /**
     * 查询集合
     */
    List<User> getUserList();

}
