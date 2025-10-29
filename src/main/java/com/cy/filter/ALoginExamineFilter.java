package com.cy.filter;

import com.alibaba.fastjson.JSON;
import com.cy.util.ResultData;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/examine")
public class ALoginExamineFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp =(HttpServletResponse)servletResponse;

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        resp.setContentType("application/json;charset=UTF-8");
        if (user!=null) {
            // 直接返回“已登录”的响应，不调用chain.doFilter()
            resp.getWriter().write(JSON.toJSONString(ResultData.ok()));
            return;
        } else {
            resp.getWriter().write(JSON.toJSONString(ResultData.fail()));
        }

    }

    @Override
    public void destroy() {

    }
}
