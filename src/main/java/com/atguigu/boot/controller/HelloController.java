package com.atguigu.boot.controller;

import com.atguigu.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @GetMapping(value = {"/login","/"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpServletRequest request){
        if(user!=null && "123456".equals(user.getPassword())){
            request.getSession().setAttribute("user",user);
            return "redirect:/main.html";
        }
        request.setAttribute("msg","请先登录");
        return "login";
    }

    @GetMapping("/main.html")
    public String toMainPage(){
        return "main";
    }


}
