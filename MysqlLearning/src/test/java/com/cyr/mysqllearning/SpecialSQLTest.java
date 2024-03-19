package com.cyr.mysqllearning;

import com.cyr.mysqllearning.mapper.SpecialSQLMapper;
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
public class SpecialSQLTest {
    @Autowired
    private SpecialSQLMapper mapper;

    @Test
    public void testGetUserByLike() throws IOException {
        List<User> user = mapper.getUserByLike("rum");
        System.out.println(user);
    }

    @Test
    public void testDeleteMore() throws IOException {
        int i = mapper.deleteMore("9,10,11");
        System.out.println(i);
    }
    @Test
    public void testInsertUser() throws IOException {
        User user = new User(null, "sby", "123", 23, "G", "123@321.com");
        mapper.insertUser(user);
        System.out.println(user);
        // 输出：User{id=10, username='ton', password='123', age=23, sex='G', email='123@321.com'}
    }
}
