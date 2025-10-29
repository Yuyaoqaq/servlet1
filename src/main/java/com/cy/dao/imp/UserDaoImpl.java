package com.cy.dao.imp;

import com.cy.dao.UserDao;
import com.cy.model.User;
import com.cy.util.DBUtil;

public class UserDaoImpl implements UserDao {

    @Override
    public User findUserByLogin(String username, String password) {
        User user = DBUtil.selectOne("select * from user where username = ? and password = ?",User.class,username,password);
        return user;
    }
}
