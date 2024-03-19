package com.cyr.mysqllearning.mapper;

import com.cyr.mysqllearning.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface ParameterMapper {
    /**
     * 单个字面量类型的参数
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 多个字面量类型的参数
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * map集合类型的参数
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 实体类类型的参数
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 使用@Param标识参数
     * @param username
     * @param password
     * @return
     */
    User CheckLoginByParam(@Param("username") String username, @Param("password") String password);
}
