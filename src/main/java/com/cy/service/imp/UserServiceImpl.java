package com.cy.service.imp;

import com.cy.dao.UserDao;
import com.cy.dao.imp.UserDaoImpl;
import com.cy.model.User;
import com.cy.service.UserService;
import com.cy.util.ResultData;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public ResultData findUserByLogin(String username, String password) {
        User user = userDao.findUserByLogin(username, password);
        if(user != null) {
            return ResultData.ok(user);
        }else{
            return ResultData.fail();
        }
    }
}
