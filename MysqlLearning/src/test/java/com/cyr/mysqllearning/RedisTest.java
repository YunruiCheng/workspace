package com.cyr.mysqllearning;


import com.cyr.mysqllearning.mapper.SelectMapper;
import com.cyr.mysqllearning.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;
//    private StringRedisTemplate stringRedisTemplate;



    /**
     * String类型
     */
    @Test
    void setString() {
        ValueOperations ops = redisTemplate.opsForValue();    // 首先redisTemplate.opsForValue的目的就是表明是以key，value形式储存到Redis数据库中数据的
        ops.setIfAbsent("address1","maoming");// 到这里就表明Redis数据库中存储了key为address1，value为zhengzhou的数据了（取的时候通过key取数据）
    }

    @Test
    void getString() {
        ValueOperations ops = redisTemplate.opsForValue();  // 表明取的是key，value型的数据
        Object o = ops.get("address1");  // 获取Redis数据库中key为address1对应的value数据
        System.out.println(o);
    }


    /**
     * Hash类型
     */
    @Test
    void setHash() {
        HashOperations ops = redisTemplate.opsForHash();// 表明数据是以哈希类型的格式进行储存到Redis数据库的
        ops.putIfAbsent("info","school","Fudan University");
        // 通过put命令，向Redis数据库中储存一个哈希类型的数据（一个为info的key里面放着一个key为a，value为aa的数据）
    }

    @Test
    void getHash() {
        HashOperations ops = redisTemplate.opsForHash();  // 表明取的是哈希类型的数据
        Object o = ops.get("info","school");  // 获取Redis数据库中哈希类型的数据（获取第一个key里面key为a的value数据）
        System.out.println(o);
    }

}
