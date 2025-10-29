package com.cy.service;

import com.cy.util.ResultData;

public interface UserService {
    ResultData findUserByLogin(String username, String password);
}
