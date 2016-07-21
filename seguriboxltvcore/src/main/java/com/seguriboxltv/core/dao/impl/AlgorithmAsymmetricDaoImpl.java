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

import com.seguriboxltv.core.dao.AlgorithmAsymmetricDao;
import com.seguriboxltv.core.domain.AlgorithmAsymmetric;

//Clase que implementa metodos para la persistencia en la tablas de AlgorithmAsymmetric
@Repository
public class AlgorithmAsymmetricDaoImpl implements AlgorithmAsymmetricDao {

    @Autowired
    private DataSource dataSource;
    private Connection conn;
    private String sql = "";
    private int returnCode = 0;
    private String returnMessage = "";
    private CallableStatement cstmt = null;
    private ResultSet rsl = null;

    ;

	public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    //Inserta dstos en la tabla AlgorithmAsymmetric
    @Override
    public int Create(AlgorithmAsymmetric algorithmAsymmetric, int cryptoModuleId, String userName, String hostName)
            throws Exception {

        int id;
        sql = "{call AlgorithmAsymmetricCreate(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            System.out.println(userName + hostName + algorithmAsymmetric.getCryptoModuleId());
            // InputStream binOid = new ByteArrayInputStream();
            // cstmt.setInt("AlgorithmId", 4);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            // cstmt.setInt("",algorithmAsymmetric.getAlgorithmAsymmetricId());
            cstmt.setShort("CryptoModuleId", (short) cryptoModuleId);
            // cstmt.setDate("", algorithmAsymmetric.getDateReference());
            cstmt.setString("AlgorithmName", algorithmAsymmetric.getAlgorithmName());
            cstmt.setString("AlgorithmDescription", algorithmAsymmetric.getAlgorithmDescription());
            cstmt.setString("Oid", algorithmAsymmetric.getOid());
            cstmt.setBytes("BinOid", algorithmAsymmetric.getBinOid());
            cstmt.setInt("MinBits", algorithmAsymmetric.getMinBits());
            cstmt.setInt("MaxBits", algorithmAsymmetric.getMaxBits());
            cstmt.setInt("DeltaBits", algorithmAsymmetric.getDeltaBits());
            cstmt.setInt("MinSecureBits", algorithmAsymmetric.getMinSecureBits());
            cstmt.setInt("Secure", algorithmAsymmetric.getSecure());
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
                System.out.println(returnMessage + ", Registro con el ID " + cstmt.getInt("AlgorithmId"));
            }
            id = cstmt.getInt("AlgorithmId");
            // cstmt.setBoolean("", algorithmAsymmetric.getIsActive());
        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            cstmt.close();

        }
        return id;

    }

    //Actualiza un registro que se identifique con AlgorithmId y se guardan los cambios en la base de datos
    public void Save(int algorithmId, String userName, String hostName, String algorithmName,
            String algorithmDescription, int secure, boolean isActive) throws Exception {

        String sql = "{call AlgorithmAsymmetricSave(?,?,?,?,?,?,?)}";

        try {
            int returnCode;
            String returnMessage;
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmId", algorithmId);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            cstmt.setString("AlgorithmName", algorithmName);
            cstmt.setString("AlgorithmDescription", algorithmDescription);
            cstmt.setInt("Secure", secure);
            cstmt.setBoolean("IsActive", isActive);
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

                System.out.println("Registro Actualizado correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {

            cstmt.close();
            conn.close();
        }

    }

    //Recupera un registro de la tabla AlgorithmAsymmetric por el id
    public AlgorithmAsymmetric GetById(int algorithmId) throws Exception {
        sql = "{call AlgorithmAsymmetricGet(?)}";
        AlgorithmAsymmetric algorithmAsymmetric = null;
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmId", algorithmId);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {
                throw new Exception("No existe Usuario con el id: " + algorithmId);
            } else {

                algorithmAsymmetric = new AlgorithmAsymmetric();
                algorithmAsymmetric.setAlgorithmAsymmetricId(rsl.getInt("AlgorithmAsymmetricId"));
                algorithmAsymmetric.setCryptoModuleId(rsl.getShort("CryptoModuleId"));
                algorithmAsymmetric.setDateReference(rsl.getDate("ReferenceDate"));
                algorithmAsymmetric.setAlgorithmName(rsl.getString("AlgorithmName"));
                algorithmAsymmetric.setAlgorithmDescription(rsl.getString("AlgorithmDescription"));
                algorithmAsymmetric.setOid(rsl.getString("Oid"));
                algorithmAsymmetric.setBinOid(rsl.getBytes("BinOid"));
                algorithmAsymmetric.setMinBits(rsl.getInt("MinBits"));
                algorithmAsymmetric.setMaxBits(rsl.getInt("MaxBits"));
                algorithmAsymmetric.setDeltaBits(rsl.getInt("DeltaBits"));
                algorithmAsymmetric.setMinSecureBits(rsl.getInt("MinSecureBits"));
                algorithmAsymmetric.setSecure(rsl.getInt("Secure"));
                algorithmAsymmetric.setIsActive(rsl.getBoolean("IsActive"));
            }

        } catch (SQLException e) {

            throw e;
        } catch (Exception e) {
            throw e;
        } finally {

            cstmt.close();
            // rsl.close();
            conn.close();

        }

        return algorithmAsymmetric;
    }

    //Recupera todos los registros de la tabla AlgorithmAsymmetric
    public List<AlgorithmAsymmetric> GetAll() throws Exception {
        String sql = "{call AlgorithmAsymmetricGet(?)}";
        List<AlgorithmAsymmetric> algorithmAsymmetrics = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmId", 0);
            rsl = cstmt.executeQuery();

            while (rsl.next()) {
                AlgorithmAsymmetric item = new AlgorithmAsymmetric();
                item.setAlgorithmAsymmetricId(rsl.getInt("AlgorithmAsymmetricId"));
                item.setCryptoModuleId(rsl.getShort("CryptoModuleId"));
                item.setDateReference(rsl.getDate("ReferenceDate"));
                item.setExpirationDate(rsl.getDate("ExpirationDate"));
                item.setAlgorithmName(rsl.getString("AlgorithmName"));
                item.setAlgorithmDescription(rsl.getString("AlgorithmDescription"));
                item.setOid(rsl.getString("Oid"));
                item.setBinOid(rsl.getBytes("BinOid"));
                item.setMinBits(rsl.getInt("MinBits"));
                item.setMaxBits(rsl.getInt("MaxBits"));
                item.setDeltaBits(rsl.getInt("DeltaBits"));
                item.setMinSecureBits(rsl.getInt("MinSecureBits"));
                item.setSecure(rsl.getInt("Secure"));
                item.setIsActive(rsl.getBoolean("IsActive"));
                algorithmAsymmetrics.add(item);

            }

        } catch (Exception e) {
            throw e;
        } finally {

            cstmt.close();
            conn.close();
        }

        return algorithmAsymmetrics;
    }

}
