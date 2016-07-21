/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao.impl;

import com.seguriboxltv.core.dao.HsmKeyDao;
import com.seguriboxltv.core.domain.Hsmkey;
import com.seguridata.certificate.sdexception.SDException;
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

/**
 *
 * @author IngGerman
 */
//Clase que implementa metodos para la persistencia en la tabla de HsmKey
@Repository
public class HsmKeyDaoImpl implements HsmKeyDao{

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

    //  Metodo para crear registros en la tabla HsmKey
    @Override
    public void Create(Hsmkey myHsmKey, String userName, String hostName) throws Exception {
        
        sql = "{call HsmKeyCreate(?,?,?,?,?,?,?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmSignId", myHsmKey.getAlgorithmSignId());
            cstmt.setString("KeyTag", myHsmKey.getKeyTag());
            cstmt.setInt("KeySize", myHsmKey.getKeySize());
            cstmt.setString("Oid", myHsmKey.getOid());
            cstmt.setBytes("Certificate", myHsmKey.getCertificate());
            cstmt.setDate("CertificateExpiration", myHsmKey.getCertificateExpiration());//Modificar
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            cstmt.registerOutParameter("HsmKeyId", Types.INTEGER);
            boolean results = cstmt.execute();
            do {
                if (results) {
                    rsl = cstmt.getResultSet();
                    if (rsl.next()) {
                        returnCode = rsl.getInt("ReturnCode");
                        returnMessage = rsl.getString("ReturnMessage");
                    }
                    if (returnCode > 0) {
                        throw new Exception(returnMessage);
                    }
                }
            } while (results);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e1) {
            throw e1;
        }
    }
    //Metodo que obtiene todos los registros de la base de datos HsmKey
    @Override
    public List<Hsmkey> GetAll() throws Exception {
        List<Hsmkey> result = new ArrayList<>();
         sql = "{call HsmKeyGet(?)}";

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("HsmKeyId", 0);
            rsl = cstmt.executeQuery();
            while (rsl.next()) {
                Hsmkey item = new Hsmkey();
                item.setHsmkeyId(rsl.getInt("HsmKeyId"));
                item.setAlgorithmSignId(rsl.getInt("AlgorithmSignId"));
                item.setKeyTag(rsl.getString("KeyTag"));
                item.setKeySize(rsl.getInt("KeySize"));
                item.setOid(rsl.getString("Oid"));
                item.setCertificate(rsl.getBytes("Certificate"));
                result.add(item);
            }

        } catch (SQLException | SDException e) {
            throw e;
        }
        return result;
        
    }

    //Metodo que actualiza los registros de la tabla HsmKey
    @Override
    public void Save(int hsmKeyId, boolean isActive, String userName, String hostName) throws Exception {
         sql = "{call HSMKeySave(?,?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("HsmKeyId", hsmKeyId);
            cstmt.setBoolean("IsActive", isActive);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("El store procedure no retorno codigo");
            } else {
                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");
            }
            if (returnCode > 0) {
                throw new Exception(returnMessage);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e1) {
            throw e1;
        }
    }

    //Metodo que obtiene registros por id de la tabla HsmKey
    @Override
    public Hsmkey GetById(int hsmKeyId) throws Exception {

        Hsmkey result = null;
        String sql = "{call HsmKeyGet(?)}";

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("HsmKeyId", hsmKeyId);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("No se ejecuto la consulta");
            } else {
                result = new Hsmkey();
                result.setHsmkeyId(rsl.getInt("HSMKeyId"));
                result.setAlgorithmSignId(rsl.getInt("AlgorithmSignId"));
                result.setKeyTag(rsl.getString("KeyTag"));
                result.setKeySize(rsl.getInt("KeySize"));
                result.setOid(rsl.getString("Oid"));
                result.setCertificate(rsl.getBytes("Certificate"));
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    

}
