package com.cyr.mybatis.mapper;

import com.cyr.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    /**
     * 根据用户名进行模糊查询
     */
    List<User> getUserByLike(@Param("username") String username);
    /**
     * 根据id批量删除
     */
    int deleteMore(@Param("ids") String ids);
    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTable(@Param("tableName") String tableName);
    /**
     * 添加用户信息
     */
    void insertUser(User user);


}
