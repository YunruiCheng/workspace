package com.cyr.mysqllearning;

import com.cyr.mysqllearning.mapper.DynamicSQLMapper;
import com.cyr.mysqllearning.mapper.SelectMapper;
import com.cyr.mysqllearning.pojo.Dept;
import com.cyr.mysqllearning.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysqlLearningApplication.class)
public class DynamicSQLTest {

    @Autowired
    private DynamicSQLMapper mapper;
    @Test
    public void testGetEmpByCondition() throws IOException {
        Emp zhangsan = new Emp(null, "libai", null, null, null, null);
        //唯一改变
        List<Emp> empByCondition = mapper.getEmpByCondition(zhangsan);
        System.out.println(empByCondition);
        // 结果：[Emp{eid=3, empName='null', age=24, sex='M', email='acbdefg@gmail.com', dept=null}]
    }

    @Test
    public void deleteMoreByArray() throws IOException {
        int result = mapper.deleteMoreByArray(new Integer[]{2,3});
        System.out.println(result);
    }
    @Test
    public void insertMoreByList() throws IOException {
        Emp emp1 = new Emp(null,"Baiden",24,"G","123@321.com",new Dept(2,"GrowFastFunds",null));
        Emp emp2 = new Emp(null,"Roben",23,"M","123@321.com",new Dept(1,"eFunds",null));
        Emp emp3 = new Emp(null,"Pony",18,"M","123@321.com",new Dept(2,"GrowFastFunds",null));
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int result = mapper.insertMoreByList(emps);
        System.out.println(result);
    }

    @Test
    public void testPageHelper() throws IOException {
        //访问第一页，每页二条数据
        PageHelper.startPage(1,2);
        List<Emp> emps = mapper.getEmpByCondition(null);
        PageInfo<Emp> page = new PageInfo<>(emps,5);
        System.out.println(page);
    }
}
