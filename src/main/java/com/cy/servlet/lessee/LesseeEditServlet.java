package com.cy.servlet.lessee;

import com.alibaba.fastjson.JSON;
import com.cy.model.Lessee;
import com.cy.service.LesseeService;
import com.cy.service.imp.LesseeServiceImpl;
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

@WebServlet("/lessee/edit")
public class LesseeEditServlet extends HttpServlet {
    LesseeService lesseeService = new LesseeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //ac
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String sex = req.getParameter("sex");
        String np = req.getParameter("np");
        String idCard = req.getParameter("idCard");
        String addTime = req.getParameter("addTime");


        Lessee lessee=new Lessee();
        lessee.setName(name);
        lessee.setTel(tel);
        lessee.setSex(Integer.parseInt(sex));
        lessee.setNp(np);
        lessee.setIdCard(idCard);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date addTime2 = sdf.parse(addTime);
            lessee.setAddTime(addTime2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        //ser
        ResultData resultData=lesseeService.updateById(lessee);

        //res
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(resultData));
    }
}
