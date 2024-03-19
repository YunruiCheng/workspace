package com.cyr.mysqllearning;

import com.cyr.mysqllearning.mapper.resultMapMapper;
import com.cyr.mysqllearning.pojo.Dept;
import com.cyr.mysqllearning.pojo.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysqlLearningApplication.class)
public class resultMapTest {
    @Autowired
    private resultMapMapper mapper;
    @Test
    public void testGetAllEmp() throws IOException {
        List<Emp> allEmp = mapper.getAllEmp();
        for(Emp e:allEmp){
            System.out.println(e);
        }
    }
    @Test
    public void testGetEmpAndDept() throws IOException {
        Emp empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);
        // 结果：Emp{eid=1, empName='zhangsan', age=21, sex='M', email='123456@qq.com', dept=Dept{did=1, deptName='eFunds', emps=null}}
    }

    @Test
    public void testGetDeptAndEmp() throws IOException {
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
        // 结果：Dept{did=1, deptName='eFunds', emps=[Emp{eid=1, empName='zhangsan', age=21, sex='M', email='123456@qq.com', dept=null},
        // Emp{eid=3, empName='libai', age=24, sex='M', email='acbdefg@gmail.com', dept=null}]}
    }

}
