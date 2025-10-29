package com.cy.dao;

import java.util.HashMap;
import java.util.List;
import com.cy.model.House;

public interface HouseDao {
    List<House> findAll(HashMap<String, Object> map);
    int count(HashMap<String,Object> map);

    boolean addOne(House house);
    boolean updateById(House house);

    boolean deleteById(int i);

    boolean pldeleteByIds(String[] ids);
}
