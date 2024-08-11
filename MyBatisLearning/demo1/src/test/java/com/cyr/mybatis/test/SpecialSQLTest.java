package com.cyr.mybatis.test;

import com.cyr.mybatis.mapper.SpecialSQLMapper;
import com.cyr.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SpecialSQLTest {
    private static SpecialSQLMapper getSqlMapper() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        return mapper;
    }

    @Test
    public void testGetUserByLike() throws IOException {
        SpecialSQLMapper mapper = getSqlMapper();
        //唯一改变
        List<User> user = mapper.getUserByLike("rum");
        System.out.println(user);
    }

    @Test
    public void testDeleteMore() throws IOException {
        //读取MyBatis的核心配置文件
        SpecialSQLMapper mapper = getSqlMapper();
        //唯一改变
        int i = mapper.deleteMore("1,2,7");
        System.out.println(i);
    }
    @Test
    public void testInsertUser() throws IOException {
        //读取MyBatis的核心配置文件
        SpecialSQLMapper mapper = getSqlMapper();
        //唯一改变
        User user = new User(null, "sby", "123", 23, "G", "123@321.com");
        mapper.insertUser(user);
        System.out.println(user);
        // 输出：User{id=10, username='ton', password='123', age=23, sex='G', email='123@321.com'}
    }
}
