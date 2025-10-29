package com.cy.servlet.house;

import com.alibaba.fastjson.JSON;
import com.cy.service.HouseService;
import com.cy.service.imp.HouseServiceImpl;
import com.cy.util.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/house/delete")
public class HouseDeleteServlet extends HttpServlet {
    HouseService houseService = new HouseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ac
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);

        //ser
        ResultData resultData= houseService.deleteById(i);

        //resp
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));

    }
}
