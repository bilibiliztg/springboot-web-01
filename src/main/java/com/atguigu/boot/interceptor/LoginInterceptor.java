package com.atguigu.boot.interceptor;


import com.atguigu.boot.bean.User;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null && "123456".equals(user.getPassword())){
            return true;
        }

        request.setAttribute("msg","先登录");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }


}
