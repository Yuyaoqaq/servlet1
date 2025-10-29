package com.cy.service.imp;

import com.cy.dao.LesseeDao;
import com.cy.model.Lessee;
import com.cy.service.LesseeService;
import com.cy.util.ResultData;
import com.cy.dao.imp.LesseeDaoImpl;

import java.util.HashMap;
import java.util.List;

public class LesseeServiceImpl implements LesseeService {
    private LesseeDao lesseeDao = new LesseeDaoImpl();
    @Override
    public ResultData findAll(HashMap<String, Object> map) {
        List<Lessee> lessee =lesseeDao.findAll(map);
        int count = lesseeDao.count(map);
        return ResultData.ok(lessee,count);
    }

    @Override
    public ResultData addOne(Lessee lessee) {
        boolean isok=lesseeDao.addOne(lessee);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData updateById(Lessee lessee) {
        boolean isok = lesseeDao.updateById(lessee);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData deleteById(int i) {
        boolean isok=lesseeDao.deleteById(i);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData pldeleteByIds(String[] ids) {
        boolean isok=lesseeDao.pldeleteByIds(ids);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }
}
