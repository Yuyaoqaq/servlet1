package com.cy.service;

import com.cy.model.Lessee;
import com.cy.util.ResultData;

import java.util.HashMap;

public interface LesseeService {
    ResultData findAll(HashMap<String, Object> map);

    ResultData addOne(Lessee lessee);

    ResultData updateById(Lessee lessee);

    ResultData deleteById(int i);

    ResultData pldeleteByIds(String[] ids);
}
