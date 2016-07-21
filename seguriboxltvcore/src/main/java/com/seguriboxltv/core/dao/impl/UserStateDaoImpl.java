/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao.impl;

import com.seguriboxltv.core.dao.AreaDao;
import com.seguriboxltv.core.dao.UserStateDao;
import com.seguriboxltv.core.domain.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author victor
 */
@Repository

public class UserStateDaoImpl implements UserStateDao {

    @Autowired
    private DataSource dataSource;
    private Connection conn;
    private String sql = "";
    private int returnCode = 0;
    private String returnMessage = "";
    private CallableStatement cstmt = null;
    private ResultSet rsl = null;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public User GetByUserName(String userName) throws SQLException, Exception {
        sql = "{call UserGet(?)}";
        User user = new User();

        try {
            conn = dataSource.getConnection();

            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", userName);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {

                throw new Exception("No existe registro en la base de datos con el username: " + userName);
            } else {

                user.setUserId(rsl.getInt("UserId"));
                user.setUserType(rsl.getByte("UserType"));
                user.setOnlyReader(rsl.getBoolean("OnlyReader"));
                user.setUsername(rsl.getString("UserName"));
                user.setPrefix(rsl.getString("Prefix"));
                user.setFirstName(rsl.getString("FirstName"));
                user.setMiddleName(rsl.getString("MiddleName"));
                user.setLastName(rsl.getString("LastName"));
                user.setRfc(rsl.getString("RFC"));
                user.setCurp(rsl.getString("CURP"));
                user.setPuesto(rsl.getString("Puesto"));
                user.setIdentificador(rsl.getString("Identificador"));
                user.setCalle(rsl.getString("Calle"));
                user.setNumero(rsl.getString("Numero"));
                user.setCodigoPostal(rsl.getString("CodigoPostal"));
                user.setMunicipio(rsl.getString("Municipio"));
                user.setColonia(rsl.getString("Colonia"));
                user.setEstado(rsl.getString("Estado"));
                user.setAuthenticationMode(rsl.getByte("AuthenticationMode"));
                user.setCertificate(rsl.getBytes("Certificate"));
                user.setHash256certificate(rsl.getString("Hash256Certificate"));
                user.setActive(rsl.getBoolean("IsActive"));
                user.setEmail(rsl.getString("Email"));
                user.setTelNumber(rsl.getString("TelNumber"));
                user.setCountryCode(rsl.getInt("CountryCode"));//String or Int
                user.setLockedOut(rsl.getBoolean("IsLockedOut"));
                user.setLastSigninDate(rsl.getDate("LastSigninDate"));
                user.setReferenceDate(rsl.getDate("ReferenceDate"));
                user.setLastUpdated(rsl.getDate("LastUpdated"));
                user.setIpaddress(rsl.getString("IPAddress"));
                user.setStatusId(rsl.getByte("StatusId"));
                user.setLastUserLogRecordId(rsl.getInt("LastUserLogRecordId"));
                user.setLastActivityDate(rsl.getDate("LastActivityDate"));
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    @Override
    public User GetById(int id) throws SQLException, Exception {
        sql = "{call UserGetById(?)}";
        User user = new User();

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("UserId", id);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {

                throw new Exception("No existe registro en la base de datos con el id: " + id);
            } else {

                user.setUserId(rsl.getInt("UserId"));
                user.setUserType(rsl.getByte("UserType"));
                user.setOnlyReader(rsl.getBoolean("OnlyReader"));
                user.setUsername(rsl.getString("UserName"));
                user.setPrefix(rsl.getString("Prefix"));
                user.setFirstName(rsl.getString("FirstName"));
                user.setMiddleName(rsl.getString("MiddleName"));
                user.setLastName(rsl.getString("LastName"));
                user.setRfc(rsl.getString("RFC"));
                user.setCurp(rsl.getString("CURP"));
                user.setPuesto(rsl.getString("Puesto"));
                user.setIdentificador(rsl.getString("Identificador"));
                user.setCalle(rsl.getString("Calle"));
                user.setNumero(rsl.getString("Numero"));
                user.setCodigoPostal(rsl.getString("CodigoPostal"));
                user.setMunicipio(rsl.getString("Municipio"));
                user.setColonia(rsl.getString("Colonia"));
                user.setEstado(rsl.getString("Estado"));
                user.setAuthenticationMode(rsl.getByte("AuthenticationMode"));
                user.setCertificate(rsl.getBytes("Certificate"));
                user.setHash256certificate(rsl.getString("Hash256Certificate"));
                user.setActive(rsl.getBoolean("IsActive"));
                user.setEmail(rsl.getString("Email"));
                user.setTelNumber(rsl.getString("TelNumber"));
                user.setCountryCode(rsl.getInt("CountryCode"));
                user.setLockedOut(rsl.getBoolean("IsLockedOut"));
                user.setLastSigninDate(rsl.getDate("LastSigninDate"));
                user.setReferenceDate(rsl.getDate("ReferenceDate"));
                user.setLastUpdated(rsl.getDate("LastUpdated"));
                user.setIpaddress(rsl.getString("IPAddress"));
                user.setStatusId(rsl.getByte("StatusId"));
                user.setLastUserLogRecordId(rsl.getInt("LastUserLogRecordId"));
                user.setLastActivityDate(rsl.getDate("LastActivityDate"));

            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return user;
    }


}
