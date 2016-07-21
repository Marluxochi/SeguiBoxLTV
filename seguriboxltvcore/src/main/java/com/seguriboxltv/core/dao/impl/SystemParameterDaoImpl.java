/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao.impl;

import com.seguriboxltv.core.dao.SystemParameterDao;
import com.seguriboxltv.core.domain.SystemParameter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author IngGerman
 */
@Repository
public class SystemParameterDaoImpl implements SystemParameterDao {

    @Autowired
    private DataSource dataSource;

    ResultSet rsl = null;
    CallableStatement cStmt = null;
    Connection conn;
    int returnCode;
    String returnMessage;
    String sql;

    public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;
    }

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
        sql = "{call SystemSetParameter(?,?,?,?,?)}";

        try {
            conn=dataSource.getConnection();
            cStmt = conn.prepareCall(sql);
            cStmt.setString("ParameterName", systemParameter.getParameterName());
            cStmt.setString("ParameterValue", systemParameter.getParameterValue());
            cStmt.setString("Category", systemParameter.getCategory());
            cStmt.setString("UserName", userName);
            cStmt.setString("HostName", hostName);
            boolean execute = cStmt.execute();

            if (execute == true) {

                System.out.println("La consulta se ejecuto correctamente");
            } else {

                throw new Exception("Hubo errores al ejecutar el Store Procedure");
            }
        } catch (SQLException e) {

            throw e;
        } catch (Exception e) {

            throw e;
        }

    }

}
