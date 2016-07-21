/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service.impl;

import com.seguriboxltv.core.dao.UserStateDao;
import com.seguriboxltv.core.domain.User;
import com.seguriboxltv.core.domain.UserState;
import com.seguriboxltv.core.service.UserStateService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victor
 */
@Service
public class UserStateServiceImpl implements UserStateService{
    @Autowired
    private UserStateDao userStateDao;
  @Override
    public User GetByUserName(String userName) throws SQLException, Exception {
        return userStateDao.GetByUserName(userName);
    }

    @Override
    public User GetById(int id) throws SQLException, Exception {
        return userStateDao.GetById(id);
    }

    
}
