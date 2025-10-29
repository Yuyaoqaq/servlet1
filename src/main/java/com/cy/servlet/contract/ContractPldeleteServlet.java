package com.cy.servlet.contract;

import com.alibaba.fastjson.JSON;
import com.cy.service.ContractService;
import com.cy.service.imp.ContractServiceImpl;
import com.cy.util.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contract/pldelete")
public class ContractPldeleteServlet extends HttpServlet {
    ContractService contractService=new ContractServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ac
        String[] ids = req.getParameterValues("ids[]");
//        System.out.println(ids);
        //ser
        ResultData resultData=contractService.pldeleteByIds(ids);

        //resp
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
