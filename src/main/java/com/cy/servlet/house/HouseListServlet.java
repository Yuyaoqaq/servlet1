package com.cy.servlet.house;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.cy.service.HouseService;
import com.cy.service.imp.HouseServiceImpl;
import com.cy.util.ResultData;

@WebServlet("/house/list")
public class HouseListServlet extends HttpServlet {
    private HouseService houseService = new HouseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //accept
//        {addr: 'beijing', floor: '', area: '', deco: '0'}
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        String addr = req.getParameter("addr");
        String floor = req.getParameter("floor");
        String area = req.getParameter("area");
        String deco = req.getParameter("deco");
        HashMap<String,Object> map=new HashMap<>();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("addr",addr);
        map.put("floor",floor);
        map.put("area",area);
        map.put("deco",deco);

        //service
        ResultData resultData = houseService.findAll(map);

        //response
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
