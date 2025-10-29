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

@WebServlet("/lessee/delete")
public class LesseeDeleteServlet extends HttpServlet {
    LesseeService lesseeService = new LesseeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ac
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);

        //ser
        ResultData resultData= lesseeService.deleteById(i);

        //resp
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));

    }
}
