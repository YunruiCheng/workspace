package com.cyr.mysqllearning.mapper;

import com.cyr.mysqllearning.pojo.Dept;
import com.cyr.mysqllearning.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface resultMapMapper {
    /**
     * 查员工表所有数据
     * @return
     */
    List<Emp> getAllEmp();

    /**
     * 多对一映射处理:1.级联方式处理映射关系。如property="dept.did"
     * @param eid
     * @return
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    //EmpMapper里的方法
    /**
     * 通过分步查询，员工及所对应的部门信息
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    //DeptMapper里的方法
    /**
     * 通过分步查询，员工及所对应的部门信息
     * 分步查询第二步：通过did查询员工对应的部门信息
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 一对多映射处理：1.collection
     * @param did
     * @return
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分步查询，查询部门及对应的所有员工信息
     * 分步查询第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
    /**
     * 通过分步查询，查询部门及对应的所有员工信息
     * 分步查询第二步：根据部门id查询部门中的所有员工
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);

}
