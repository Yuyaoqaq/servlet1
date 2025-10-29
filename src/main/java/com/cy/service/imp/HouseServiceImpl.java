package com.cy.service.imp;

import com.cy.dao.HouseDao;
import com.cy.dao.imp.HouseDaoImpl;
import com.cy.model.House;
import com.cy.service.HouseService;
import com.cy.util.ResultData;

import java.util.HashMap;
import java.util.List;

public class HouseServiceImpl implements HouseService {
private HouseDao houseDao = new HouseDaoImpl();
    @Override
    public ResultData findAll(HashMap<String, Object> map) {
        List<House> house =houseDao.findAll(map);
        int count = houseDao.count(map);
        return ResultData.ok(house,count);
    }

    @Override
    public ResultData addOne(House house) {
        boolean isok=houseDao.addOne(house);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData updateById(House house) {
        boolean isok = houseDao.updateById(house);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData deleteById(int i) {
        boolean isok=houseDao.deleteById(i);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData pldeleteByIds(String[] ids) {
        boolean isok=houseDao.pldeleteByIds(ids);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }
}
