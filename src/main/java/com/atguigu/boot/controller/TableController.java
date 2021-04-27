package com.atguigu.boot.controller;

import com.atguigu.boot.bean.User;
import com.atguigu.boot.exception.MyDefinedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/sql")
    @ResponseBody
    public String sql(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_employee", Long.class);
        return "查询到的数量"+aLong;
    }

    @RequestMapping("/basic_table")
    public String basic_table(){
//        int i=10/0;
        return "table/basic_table";
    }

    @RequestMapping("/dynamic_table")
    public String dynamic_table(/*@RequestParam(value = "i",required = false) Integer i,*/ Model model){
        List<User> users = new LinkedList<>(Arrays.asList(new User("李四", "2233"),
                new User("吉吉", "55"),
                new User("旺旺", "223663"),
                new User("大白", "22003")));
        model.addAttribute("users",users);
//        if(i==1){
//            throw new MyDefinedException();
//        }
        return "table/dynamic_table";
    }

    @RequestMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @RequestMapping("/editable_table")
    public String editable_table(){
        return "redirect:/emps";
    }

    @RequestMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

}
