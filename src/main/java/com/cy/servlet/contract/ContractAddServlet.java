package com.cy.servlet.contract;

import com.alibaba.fastjson.JSON;
import com.cy.model.Contract;
import com.cy.service.ContractService;
import com.cy.service.imp.ContractServiceImpl;
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

@WebServlet("/contract/add")
public class ContractAddServlet extends HttpServlet {
    ContractService contractService = new ContractServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //accept
        String num = req.getParameter("num");
        String hid = req.getParameter("hid");
        String lid = req.getParameter("lid");

        String time = req.getParameter("time");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String totalMoney = req.getParameter("totalMoney");
        String payType = req.getParameter("payType");


        Contract contract=new Contract();
        contract.setNum(num);
        contract.setHid(Integer.parseInt(hid));
        contract.setLid(Integer.parseInt(lid));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date time1 = sdf.parse(time);
            Date starttime = sdf.parse(startTime);
            Date endtime = sdf.parse(endTime);
            contract.setTime(time1);
            contract.setStartTime(starttime);
            contract.setEndTime(endtime);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        contract.setTotalMoney(Double.parseDouble(totalMoney));
        contract.setPayType(Integer.parseInt(payType));
        
        //service
        ResultData resultData =contractService.addOne(contract);

        //response
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
