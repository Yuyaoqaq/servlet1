package com.cy.servlet.user;

import com.alibaba.fastjson.JSON;
import com.cy.util.ResultData;
import com.cy.service.UserService;
import com.cy.service.imp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //accept
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //service
        ResultData resultData = userService.findUserByLogin(username,password);
        System.out.println(resultData.getData());
        if(resultData.getCode()==0){
            HttpSession session = req.getSession();

            session.setAttribute("user",resultData.getData());
        }

        //response
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
