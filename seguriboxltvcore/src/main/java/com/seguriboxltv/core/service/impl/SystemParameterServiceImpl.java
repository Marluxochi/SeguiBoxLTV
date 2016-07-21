/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service.impl;

import com.seguriboxltv.core.dao.SystemParameterDao;
import com.seguriboxltv.core.domain.SystemParameter;
import com.seguriboxltv.core.service.SystemParameterService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author IngGerman
 */

@Service
public class SystemParameterServiceImpl implements SystemParameterService{

    @Autowired
    SystemParameterDao systemPDao;
    
    @Override
    public List<SystemParameter> GetAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemParameter GetByPramName(String paramName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SystemParameter> GetByCategory(String category) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Set(SystemParameter systemParameter, String userName, String hostName) throws Exception {
        systemPDao.Set(systemParameter, userName, hostName);
    }
    
}
