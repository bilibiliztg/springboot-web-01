package com.atguigu.boot.service;

import com.atguigu.boot.bean.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

public interface EmpService extends IService<Employee> {
    public Employee getEmp(Integer id);

    public void insertEmp(Employee employee);
}
