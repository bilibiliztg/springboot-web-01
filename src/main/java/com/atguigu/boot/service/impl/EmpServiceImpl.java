package com.atguigu.boot.service.impl;

import com.atguigu.boot.bean.Employee;
import com.atguigu.boot.mapper.EmpMapper;
import com.atguigu.boot.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper,Employee> implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    public Employee getEmp(Integer id){
        return empMapper.getEmp(id);
    }

    public void insertEmp(Employee employee){
        empMapper.insert(employee);
    }
}
