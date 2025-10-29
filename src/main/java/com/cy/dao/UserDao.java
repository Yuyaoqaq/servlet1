package com.cy.dao;

import com.cy.model.User;

import java.util.HashMap;

public interface UserDao {
    User findUserByLogin(String username, String password);

}
