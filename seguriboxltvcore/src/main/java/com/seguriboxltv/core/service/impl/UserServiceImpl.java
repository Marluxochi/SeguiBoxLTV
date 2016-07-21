/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service.impl;

import com.seguriboxltv.core.dao.UserDao;
import com.seguriboxltv.core.domain.User;
import com.seguriboxltv.core.service.UserService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author victor
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int Create(User user, String userName, String hostName) throws SQLException, Exception {
       return userDao.Create(user, userName, hostName);
    }

    @Override
    public void Delete(String userName, String invokedBy, String hostIP) throws SQLException, Exception {
       userDao.Delete(userName, invokedBy, hostIP);
    }

    @Override
    public User GetByUserName(String userName) throws SQLException, Exception {
        return userDao.GetByUserName(userName);
    }

    @Override
    public User GetById(int id) throws SQLException, Exception {
        return userDao.GetById(id);
    }

    @Override
    public void Lock(String userName, String invokedBy, String hostIP) throws SQLException, Exception {
         userDao.Lock(userName, invokedBy, hostIP);
    }

    @Override
    public void Save(User user, String invokedBy, String hostIP) throws SQLException, Exception {
        userDao.Save(user, invokedBy, hostIP);
    }

    @Override
    public List<User> Search(String search, short pageSize, short currentPage, int recordCount) throws SQLException, Exception {
        return userDao.Search(search, pageSize, currentPage, recordCount);
    }

    @Override
    public void SignIn(String userName, String ipAdress) throws SQLException, Exception {
        userDao.SignIn(userName, ipAdress);
    }

    @Override
    public void SignOut(int userId) throws SQLException, Exception {
        userDao.SignOut(userId);
    }

    @Override
    public User GetStateByUserName(String userName) throws SQLException, Exception {
       return  userDao.GetStateByUserName(userName);
    }

    @Override
    public User GetStateById(int id) throws SQLException, Exception {
        return userDao.GetStateById(id);
    }

    @Override
    public void Unlock(String userName, String invokedBy, String HostIP) throws SQLException, Exception {
        userDao.Unlock(userName, invokedBy, HostIP);
    }

    @Override
    public void ResetPassword(String userName, String password) throws SQLException, Exception {
        userDao.ResetPassword(userName, password);
    }

    @Override
    @Transactional
    public int MembershipValidateUser(String userName, String password, String hostName) throws SQLException, Exception {
       return userDao.MembershipValidateUser(userName, password, hostName);
    }

}