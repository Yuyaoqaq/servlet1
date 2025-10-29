package com.cy.servlet.house;

import com.alibaba.fastjson.JSON;
import com.cy.model.House;
import com.cy.service.HouseService;
import com.cy.service.imp.HouseServiceImpl;
import com.cy.util.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/house/add")
public class HouseAddServlet extends HttpServlet {
    HouseService houseService = new HouseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //accept
        String address = req.getParameter("address");
        String floor = req.getParameter("floor");
        String roomNum = req.getParameter("roomNum");
        String area = req.getParameter("area");
        String dir = req.getParameter("dir");
        String deco = req.getParameter("deco");
        String air = req.getParameter("air");
        String price = req.getParameter("price");
        String rentStatus = req.getParameter("rentStatus");
        String addTime = req.getParameter("addTime");
        String status = req.getParameter("status");

        House house=new House();
        house.setAddress(address);
        house.setFloor(Integer.parseInt(floor));
        house.setRoomNum(Integer.parseInt(roomNum));
        house.setArea(area);
        house.setDir(dir);
        house.setDeco(Integer.parseInt(deco));
        house.setAir(Integer.parseInt(air));
        house.setPrice(Double.parseDouble(price));
        if(status.equals("0")){
            // 方案2：如果不允许为0，返回错误提示
            ResultData resultData = ResultData.fail("请选择有效的状态");
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(JSON.toJSONString(resultData));
             return;
        }
        house.setRentStatus(Integer.parseInt(rentStatus));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date addTime2 = sdf.parse(addTime);
            house.setAddTime(addTime2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        house.setStatus(Integer.parseInt(status));
        //service
        ResultData resultData =houseService.addOne(house);

        //response
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
