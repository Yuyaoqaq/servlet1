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
import java.util.HashMap;

@WebServlet("/lessee/list")
public class LesseeListServlet extends HttpServlet {
    private LesseeService lesseeService = new LesseeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //accept
//        {addr: 'beijing', floor: '', area: '', deco: '0'}
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        String name = req.getParameter("name");
        String idCard = req.getParameter("idCard");

        HashMap<String,Object> map=new HashMap<>();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("name",name);
        map.put("idCard",idCard);

        //service
        ResultData resultData = lesseeService.findAll(map);

        //response
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
