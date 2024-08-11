package com.cyr.mybatis.test;

import com.cyr.mybatis.mapper.ParameterMapper;
import com.cyr.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ParameterTest {
    private static ParameterMapper getMapper() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        return mapper;
    }
    @Test
    public void testGetUserList() throws IOException {
        //读取MyBatis的核心配置文件
        ParameterMapper mapper = getMapper();
        //唯一改变
        User zhangsan = mapper.getUserByUsername("zhangsan");
        System.out.println(zhangsan);
    }

    @Test
    public void testInsertUser() throws IOException {
        ParameterMapper mapper = getMapper();
        //唯一改变
        User user = new User(null,"Thrump","123456",12,"M","123@321.com");
        mapper.insertUser(user);
    }

    @Test
    public void testCheckLoginByParam() throws IOException {
        //读取MyBatis的核心配置文件
        ParameterMapper mapper = getMapper();
        //唯一改变
        mapper.CheckLoginByParam("Thrump","123456");
    }
}
