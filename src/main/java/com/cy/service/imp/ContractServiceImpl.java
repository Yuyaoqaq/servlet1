package com.cy.service.imp;

import com.cy.dao.ContractDao;
import com.cy.dao.imp.ContractDaoImpl;
import com.cy.model.Contract;
import com.cy.model.VO.ContractVO;
import com.cy.service.ContractService;
import com.cy.util.ResultData;

import java.util.HashMap;
import java.util.List;

public class ContractServiceImpl implements ContractService {
private ContractDao contractDao = new ContractDaoImpl();
    @Override
    public ResultData findAll(HashMap<String, Object> map) {
        List<ContractVO> contractVO =contractDao.findAll(map);
        int count = contractDao.count(map);
        return ResultData.ok(contractVO,count);
    }

    @Override
    public ResultData addOne(Contract contract) {
        boolean isok=contractDao.addOne(contract);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData updateById(Contract contract) {
        boolean isok = contractDao.updateById(contract);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData deleteById(int i) {
        boolean isok=contractDao.deleteById(i);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData pldeleteByIds(String[] ids) {
        boolean isok=contractDao.pldeleteByIds(ids);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }
}
