/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service;

import com.seguriboxltv.core.domain.SystemParameter;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author IngGerman
 */
public interface SystemParameterService {
   public List<SystemParameter> GetAll() throws SQLException;
    public SystemParameter GetByPramName(String paramName) throws Exception;
    public List<SystemParameter> GetByCategory(String category) throws SQLException;
    public void Set(SystemParameter systemParameter, String userName, String hostName) throws Exception; 
}
