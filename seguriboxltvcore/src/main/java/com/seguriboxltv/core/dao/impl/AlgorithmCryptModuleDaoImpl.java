package com.seguriboxltv.core.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.seguriboxltv.core.dao.AlgorithmCryptModuleDao;
import com.seguriboxltv.core.domain.AlgorithmCryptModule;
import com.seguridata.crypto.sdexception.SDException;

//Clase que implementa metodos para la persistencia en la tabla de AlgorithmCrypt
@Repository
public class AlgorithmCryptModuleDaoImpl implements AlgorithmCryptModuleDao {

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

    //Metodo que guarda  los registros en la tabla AlgorithmCrypt
    @Override
    public int Create(String userName, String hostName) throws Exception {
        sql = "{call AlgorithmCryptoCreate(?,?,?,?,?)}";
        System.out.println("holamundo");
        short cryptoModuleId;
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            cstmt.setString("ModuleVersion", "1.5");
            cstmt.setString("Description", "Description");
            cstmt.registerOutParameter("CryptoModuleId", Types.SMALLINT);
            rsl = cstmt.executeQuery();
            // boolean isResultSet=cstmt.execute();

            //
            if (!rsl.next()) {

                throw new Exception("El store procedure no retorno codigo");
            } else {

                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");

            }

            if (returnCode > 0) {
                cstmt.close();
                throw new Exception(returnMessage);

            } else {

                cryptoModuleId = cstmt.getShort("CryptoModuleId");

                cstmt.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } catch (SDException e) {
            e.printStackTrace();
            throw e;

        }
        System.out.println("holamundo" + cryptoModuleId);
        return cryptoModuleId;

    }

    //Metodo que obtiene todos los registros de la tabla AlgorithmCrypt
    @Override
    public List<AlgorithmCryptModule> GetAll() throws SQLException, Exception {
        List<AlgorithmCryptModule> algorithmCryptModules;
        try {
            String sql = "{call AlgorithmCryptoGet(?)}";
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("CryptoModuleId", 0);
            cstmt.registerOutParameter("CryptoModuleId", Types.INTEGER);
            rsl = cstmt.executeQuery();

            algorithmCryptModules = new ArrayList<>();

            if (!rsl.next()) {

                throw new Exception("No existen registros en la base de datos");
            } else {
                while (rsl.next()) {
                    AlgorithmCryptModule item = new AlgorithmCryptModule();
                    item.setCryptoModuleId(rsl.getShort("CryptoModuleId"));
                    item.setDateReference(rsl.getDate("ReferenceDate"));
                    item.setExpirationDate(rsl.getDate("ExpirationDate"));
                    item.setModuleVersion(rsl.getString("ModuleVersion"));
                    item.setDescription(rsl.getString("Description"));
                    item.setActive(rsl.getBoolean("IsActive"));
                    algorithmCryptModules.add(item);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return algorithmCryptModules;
    }

    //Metodo que obtiene un registro por id de la tabla AlgorithmCrypt
    @Override
    public AlgorithmCryptModule GetbyId(int id) throws Exception {

        AlgorithmCryptModule algorithmCryptModule = null;
        try {
            String sql = "{call AlgorithmCryptoGet(?)}";
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("CryptoModuleId", id);
            cstmt.registerOutParameter("CryptoModuleId", Types.INTEGER);
            rsl = cstmt.executeQuery();

            if (rsl.next()) {

                algorithmCryptModule = new AlgorithmCryptModule();
                algorithmCryptModule.setCryptoModuleId(rsl.getShort("CryptoModuleId"));
                algorithmCryptModule.setDateReference(rsl.getDate("ReferenceDate"));
                algorithmCryptModule.setExpirationDate(rsl.getDate("ExpirationDate"));
                algorithmCryptModule.setModuleVersion(rsl.getString("ModuleVersion"));
                algorithmCryptModule.setDescription(rsl.getString("Description"));
                algorithmCryptModule.setActive(rsl.getBoolean("IsActive"));
            } else {

                throw new Exception("No existe registro en la base de datos con el id " + id);
            }

        } catch (Exception e) {
            throw e;
        }

        return algorithmCryptModule;
    }

}
