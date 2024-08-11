package com.cyr.mybatis.test;

import com.cyr.mybatis.mapper.UserMapper;
import com.cyr.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    private static UserMapper getMapper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper;
    }
    @Test
    public void testInsertUser() throws IOException{
        //读取MyBatis的核心配置文件
        UserMapper userMapper = getMapper();
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        //提交事务
        //sqlSession.commit();
        System.out.println("result:" + result);
    }

    @Test
    public void testUpdateUser() throws IOException{
        //读取MyBatis的核心配置文件
        UserMapper userMapper = getMapper();
        //唯一改变
        int result = userMapper.updateUser();
        System.out.println("result:" + result);
    }

    @Test
    public void testDeleteUser() throws IOException{
        //读取MyBatis的核心配置文件
        UserMapper userMapper = getMapper();
        //唯一改变
        int result = userMapper.deleteUser();
        System.out.println("result:" + result);
    }

    @Test
    public void testGetUserById() throws IOException{
        //读取MyBatis的核心配置文件
        UserMapper userMapper = getMapper();
        //唯一改变
        User userbyId = userMapper.getUserbyId();
        System.out.println("result:" + userbyId);
    }

    @Test
    public void testGetUserList() throws IOException{
        //读取MyBatis的核心配置文件
        UserMapper userMapper = getMapper();
        //唯一改变
        List<User> userList = userMapper.getUserList();
        for(User u:userList){
            System.out.println("result:" + u);
        }
    }
}
