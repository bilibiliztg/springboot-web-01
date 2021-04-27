package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Employee;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.service.EmpService;
import com.atguigu.boot.service.impl.EmpServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MapperController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable("id") Integer id){
        return empService.getEmp(id);
    }

    @PostMapping("/emp")
    @ResponseBody
    public Employee insertEmp(Employee employee){
        empService.insertEmp(employee);
        return employee;
    }

    @GetMapping("/emps")
    public String getEmps(@RequestParam(value = "current",required = true,defaultValue = "1") Integer current,
                          @RequestParam(value = "size",required = false,defaultValue = "2") Integer size,
                          Model model){
        Page<Employee> userPage = new Page<Employee>(current,size);
        Page<Employee> page = empService.page(userPage, null);
        model.addAttribute("page",page);
        return "table/editable_table";
    }

    @GetMapping("/del/{id}")
    public String delEmp(@PathVariable(value = "id") Integer id,
                         @RequestParam(value = "current") Integer current,
                         RedirectAttributes redirectAttributes){
        empService.removeById(id);
        redirectAttributes.addAttribute("current",current);
        return "redirect:/emps";
    }

}
