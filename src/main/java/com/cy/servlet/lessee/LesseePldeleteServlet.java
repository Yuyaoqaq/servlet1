package com.cy.servlet.lessee;

import com.alibaba.fastjson.JSON;
import com.cy.service.LesseeService;
import com.cy.service.imp.LesseeServiceImpl;
import com.cy.util.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lessee/pldelete")
public class LesseePldeleteServlet extends HttpServlet {
    LesseeService lesseeService=new LesseeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ac
        String[] ids = req.getParameterValues("ids[]");
//        System.out.println(ids);
        //ser
        ResultData resultData=lesseeService.pldeleteByIds(ids);

        //resp
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
