/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service;

import com.seguriboxltv.core.domain.User;
import java.sql.SQLException;

/**
 *
 * @author victor
 */
public interface UserStateService {

    public User GetByUserName(String userName) throws SQLException, Exception;

    public User GetById(int id) throws SQLException, Exception;

}
