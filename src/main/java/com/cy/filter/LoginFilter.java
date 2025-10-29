package com.cy.filter;


import com.alibaba.fastjson.JSON;
import com.cy.util.ResultData;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 转换为Http类型的请求和响应
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

       // 获取请求路径，用于排除不需要拦截的资源
        String path = req.getRequestURI();
//        System.out.println(path);

//        定义不需要拦截的路径（登录页、登录接口、静态资源等）
        if ((path.contains("login")) ||    // 登录页面（重定向之后是GET请求）
                path.contains("/house/list")||
                path.contains("index")||
                path.contains("/static/")||
                path.contains("/house/houselist")){
            // 不需要拦截，直接放行
            chain.doFilter(request, response);
            return;
        }

        //设置一下编码
        //req.setCharacterEncoding("UTF-8");
        //resp.setContentType("application/json;charset=UTF-8"); // 直接固定,每个响应都是json


//        检查session中是否有登录用户
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");  // 登录成功后用户对象存入session,key为"user"
        if (user != null) {
            // 已登录，放行
            chain.doFilter(request, response);
        } else {
            // 未登录，重定向到登录页
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }


//    // 放行
//        chain.doFilter(req,resp);}
    @Override
    public void destroy() {
    }
}
