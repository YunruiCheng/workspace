package com.cyr.mysqllearning;

import com.cyr.mysqllearning.mapper.UserMapper;
import com.cyr.mysqllearning.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysqlLearningApplication.class)
public class UserTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void testInsertUser() throws IOException{
        int result = userMapper.insertUser();
        //提交事务
        //sqlSession.commit();
        System.out.println("result:" + result);
    }

    @Test
    public void testUpdateUser() throws IOException{
        int result = userMapper.updateUser();
        System.out.println("result:" + result);
    }

    @Test
    public void testDeleteUser() throws IOException{
        int result = userMapper.deleteUser();
        System.out.println("result:" + result);
    }

    @Test
    public void testGetUserById() throws IOException{
        User userbyId = userMapper.getUserbyId();
        System.out.println("result:" + userbyId);
    }

    @Test
    public void testGetUserList() throws IOException{
        List<User> userList = userMapper.getUserList();
        for(User u:userList){
            System.out.println("result:" + u);
        }
    }
}
