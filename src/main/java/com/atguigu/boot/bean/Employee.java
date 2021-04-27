package com.atguigu.boot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@TableName("t_employee")
public class Employee {
    private Integer id;
    private String empName;
    private Integer gender;
    private String email;
}
