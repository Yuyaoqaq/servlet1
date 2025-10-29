package com.cy.service;

import com.cy.model.House;
import com.cy.util.ResultData;

import java.util.HashMap;

public interface HouseService {
    ResultData findAll(HashMap<String, Object> map);

    ResultData addOne(House house);

    ResultData updateById(House house);

    ResultData deleteById(int i);

    ResultData pldeleteByIds(String[] ids);
}
