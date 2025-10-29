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
import java.util.HashMap;

@WebServlet("/contract/list")
public class ConotractListServlet extends HttpServlet {
    private ContractService contractService = new ContractServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //accept
//        {addr: 'beijing', floor: '', area: '', deco: '0'}
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        String num = req.getParameter("num");
        HashMap<String,Object> map=new HashMap<>();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("num",num);


        //service
        ResultData resultData = contractService.findAll(map);

        //response
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
