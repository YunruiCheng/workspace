package com.cyr.mybatis.test;

import com.cyr.mybatis.mapper.SelectMapper;
import com.cyr.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class SelectTest {
    private static SelectMapper getSelectMapper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        return mapper;
    }

    @Test
    public void testGetUserById() throws IOException {
        //读取MyBatis的核心配置文件
        SelectMapper mapper = getSelectMapper();
        //唯一改变
        User userById = mapper.getUserById(10);
        System.out.println(userById);
//      结果：User{id=10, username='ton', password='123', age=23, sex='G', email='123@321.com'}
    }
    @Test
    public void testGetUserToMap() throws IOException {
        //读取MyBatis的核心配置文件
        SelectMapper mapper = getSelectMapper();
        //唯一改变
        Map<String, Object> userToMap = mapper.getUserToMap(10);
        System.out.println(userToMap);
//        结果：{password=123, sex=G, id=10, age=23, email=123@321.com, username=ton}
    }

    @Test
    public void testGetUserList() throws IOException {
        //读取MyBatis的核心配置文件
        SelectMapper mapper = getSelectMapper();
        //唯一改变
        List<User> userList = mapper.getUserList();
        System.out.println(userList);
//        结果为：[User{id=3, username='admin', password='123456', age=23, sex='M', email='123456@qq.com'},
//        User{id=4, username='admin', password='123456', age=23, sex='M', email='123456@qq.com'},
//        User{id=6, username='zhangsan', password='123456', age=23, sex='M', email='123456@qq.com'}]
    }

    @Test
    public void testGetAllUserToMap() throws IOException {
        //读取MyBatis的核心配置文件
        SelectMapper mapper = getSelectMapper();
        //唯一改变
        List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
//        结果：[{password=123456, sex=M, id=3, age=23, email=123456@qq.com, username=admin},
//        {password=123456, sex=M, id=4, age=23, email=123456@qq.com, username=admin},
//        {password=123456, sex=M, id=6, age=23, email=123456@qq.com, username=zhangsan},
    }

}
