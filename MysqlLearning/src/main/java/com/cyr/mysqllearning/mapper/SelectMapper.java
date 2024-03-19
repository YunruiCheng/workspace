package com.cyr.mysqllearning.mapper;

import com.cyr.mysqllearning.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SelectMapper {
    /**
     * 查询一个实体类对象
     */
    User getUserById(@Param("id") int id);

    /**
     * 查询一个实体类对象作为：map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserToMap(@Param("id") int id);

    /**
     * 查询所有实体类对象的list
     * @return
     */
    List<User> getUserList();


    /**
     * 查询所有实体类对象的map集合的list
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，此时可以将这些map放在一个list集合中获取
     */
    List<Map<String, Object>> getAllUserToMap();


    /**
     * 查询用户的总记录数
     * @return
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer-->int|integer
     * 例如：int-->_int|_integer
     * 例如：Map-->map,List-->list
     */
    int getCount();

}
