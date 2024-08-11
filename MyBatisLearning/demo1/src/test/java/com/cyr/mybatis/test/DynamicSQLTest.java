package com.cyr.mybatis.test;

import com.cyr.mybatis.mapper.DynamicSQLMapper;
import com.cyr.mybatis.mapper.resultMapMapper;
import com.cyr.mybatis.pojo.Dept;
import com.cyr.mybatis.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class DynamicSQLTest {
    private static DynamicSQLMapper getMapper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        return mapper;
    }
    @Test
    public void testGetEmpByCondition() throws IOException {
        //读取MyBatis的核心配置文件
        DynamicSQLMapper mapper = getMapper();
        Emp zhangsan = new Emp(null, "libai", null, null, null, null);
        //唯一改变
        List<Emp> empByCondition = mapper.getEmpByCondition(zhangsan);
        System.out.println(empByCondition);
        // 结果：[Emp{eid=3, empName='null', age=24, sex='M', email='acbdefg@gmail.com', dept=null}]
    }

    @Test
    public void deleteMoreByArray() throws IOException {
        //读取MyBatis的核心配置文件
        DynamicSQLMapper mapper = getMapper();
        int result = mapper.deleteMoreByArray(new Integer[]{2,3});
        System.out.println(result);
    }
    @Test
    public void insertMoreByList() throws IOException {
        //读取MyBatis的核心配置文件
        DynamicSQLMapper mapper = getMapper();
        Emp emp1 = new Emp(null,"Baiden",24,"G","123@321.com",new Dept(2,"GrowFastFunds",null));
        Emp emp2 = new Emp(null,"Roben",23,"M","123@321.com",new Dept(1,"eFunds",null));
        Emp emp3 = new Emp(null,"Pony",18,"M","123@321.com",new Dept(2,"GrowFastFunds",null));
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int result = mapper.insertMoreByList(emps);
        System.out.println(result);
    }

    /**
     * 分页显示：使用分页插件：PageHelper
     * @throws IOException
     */
    @Test
    public void testPageHelper() throws IOException {
        //读取MyBatis的核心配置文件
        DynamicSQLMapper mapper = getMapper();
        //访问第一页，每页四条数据
        PageHelper.startPage(1,2);
        List<Emp> emps = mapper.getEmpByCondition(null);
        // 第二个参数是表示导航页码数量的参数，这里设置为5
        PageInfo<Emp> page = new PageInfo<>(emps,5);
        System.out.println(page);
    }
}
