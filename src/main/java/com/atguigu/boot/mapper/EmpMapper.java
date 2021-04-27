package com.atguigu.boot.mapper;

import com.atguigu.boot.bean.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper extends BaseMapper<Employee> {

    @Select("select * from t_employee where id=#{id}")
    public Employee getEmp(Integer id);

    public int insert(Employee employee);

}
