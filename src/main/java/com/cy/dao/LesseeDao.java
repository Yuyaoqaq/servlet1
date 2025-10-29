package com.cy.dao;

import com.cy.model.Lessee;

import java.util.HashMap;
import java.util.List;

public interface LesseeDao {

    List<Lessee> findAll(HashMap<String, Object> map);

    int count(HashMap<String, Object> map);

    boolean addOne(Lessee lessee);

    boolean updateById(Lessee lessee);

    boolean deleteById(int i);

    boolean pldeleteByIds(String[] ids);
}
