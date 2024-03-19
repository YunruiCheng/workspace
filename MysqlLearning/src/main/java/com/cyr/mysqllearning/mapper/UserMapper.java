package com.cyr.mysqllearning.mapper;

import com.cyr.mysqllearning.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
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
