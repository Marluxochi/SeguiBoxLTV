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

import com.seguriboxltv.core.dao.AlgorithmHashDao;
import com.seguriboxltv.core.domain.AlgorithmHash;

//Clase que implementa metodos para la persistencia en la tabla de AlgorithmHash
@Repository
public class AlgorithmHashDaoImpl implements AlgorithmHashDao {

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

    //Metodo que guarda  los registros en la tabla AlgorithmHash 
    @Override
    public int Create(AlgorithmHash algorithmHash, int cryptoModuleId, String userName, String hostName)
            throws Exception {
        //System.out.println("com.seguriboxltv.core.dao.impl.AlgorithmHashDaoImpl.Create()");
        sql = "{call AlgorithmHashCreate(?,?,?,?,?,?,?,?,?,?,?)}";
        int id = 0;
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);

            // InputStream binOid = new ByteArrayInputStream();
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            cstmt.setInt("CryptoModuleId", (short) cryptoModuleId);
            cstmt.setString("AlgorithmName", algorithmHash.getAlgorithmName());
            cstmt.setString("AlgorithmDescription", algorithmHash.getAlgorithmDescription());
            cstmt.setString("Oid", algorithmHash.getOid());
            cstmt.setBytes("BinOid", algorithmHash.getBinOid());
            cstmt.setInt("Bits", algorithmHash.getBits());
            cstmt.setInt("Bytes", algorithmHash.getBytes());
            cstmt.setInt("Secure", algorithmHash.getSecure());
            cstmt.registerOutParameter("AlgorithmId", Types.INTEGER);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {

                throw new Exception("El store procedure no retorno codigo");
            } else {

                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");

            }

            if (returnCode > 0) {

                throw new Exception(returnMessage);
            } else {
                id = cstmt.getInt("AlgorithmId");
                System.out.println("El registro con el id: " + id + " se creo correctamente");
            }

            System.out.println("out parameterhash: " + cstmt.getInt("AlgorithmId"));
        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        } finally {
            cstmt.close();

        }
        return id;

    }

    //Metodo que actualiza los registros 
    @Override
    public void Save(int algorithmId, String userName, String hostName, String algorithmName,
            String algorithmDescription, int secure, boolean isActive) throws SQLException {

        sql = "{call AlgorithmHashSave(?,?,?,?,?,?)}";

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmId", algorithmId);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            cstmt.setString("AlgorithmName", algorithmName);
            cstmt.setString("AlgorithmDescription", algorithmDescription);
            // cstmt.setInt("Secure", secure);
            System.out.println("desde hash dao impl valor activo? "+isActive);
            cstmt.setBoolean("IsActive", isActive);
            rsl = cstmt.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    //Metodo que obtiene un registro por id de la tabla AlgorithmHash
    @Override
    public AlgorithmHash GetById(int algorithmId) throws Exception {

        sql = "{call AlgorithmHashGet(?)}";
        AlgorithmHash algorithmHash = new AlgorithmHash();
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmId", algorithmId);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {
                throw new Exception("No hay registros encontrados en la tabla");

            } else {

                algorithmHash.setAlgorithmHashId(rsl.getInt("AlgorithmHashId"));
                algorithmHash.setCriptoModuleId(rsl.getShort("CryptoModuleId"));
                algorithmHash.setDateReference(rsl.getDate("ReferenceDate"));
                algorithmHash.setExpirationDate(rsl.getDate("ExpirationDate"));
                algorithmHash.setAlgorithmName(rsl.getString("AlgorithmName"));
                algorithmHash.setAlgorithmDescription(rsl.getString("AlgorithmDescription"));
                algorithmHash.setOid(rsl.getString("Oid"));
                algorithmHash.setBinOid(rsl.getBytes("BinOid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return algorithmHash;

    }

    //Metodo que obtiene todos los registros de la tabla AlgorithmHash
    @Override
    public List<AlgorithmHash> GetAll() throws SQLException {

        sql = "{call AlgorithmHashGet(?)}";
        List<AlgorithmHash> algorithmHash = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmId", 0);
            rsl = cstmt.executeQuery();

            while (rsl.next()) {
                AlgorithmHash item = new AlgorithmHash();
                item.setAlgorithmHashId(rsl.getInt("AlgorithmHashId"));
                item.setCriptoModuleId(rsl.getShort("CryptoModuleId"));
                item.setDateReference(rsl.getDate("ReferenceDate"));
                item.setExpirationDate(rsl.getDate("ExpirationDate"));
                item.setAlgorithmName(rsl.getString("AlgorithmName"));
                item.setAlgorithmDescription(rsl.getString("AlgorithmDescription"));
                item.setActive(rsl.getBoolean("IsActive"));
                item.setOid(rsl.getString("Oid"));
                item.setBinOid(rsl.getBytes("BinOid"));
                algorithmHash.add(item);
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return algorithmHash;
    }

}
