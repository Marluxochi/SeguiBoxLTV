package com.seguriboxltv.core.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seguriboxltv.core.dao.AlgorithmSignSymmDao;
import com.seguriboxltv.core.domain.AlgorithmSignSymm;
import java.sql.SQLException;

//Clase que implementa metodos para la persistencia en la tabla de AlgorithmSignSymm
@Repository
public class AlgorithmSignSymmDaoImpl implements AlgorithmSignSymmDao {

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

    //Metodo que crea registros en la tabla AlgorithmSignSymm
    @Override
    public int create(AlgorithmSignSymm algorithmSSS, int cryptoModuleId, String userName, String hostName, int assymetricId, int hashId)
            throws Exception {

        sql = "{call  AlgorithmSignSymmCreate(?,?,?,?,?,?,?,?,?,?,?,?)}";
        int id = 0;
        try {

            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmHashId", hashId);
            cstmt.setInt("AlgorithmAsymmetricId", assymetricId);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            cstmt.setInt("CryptoModuleId", (short) cryptoModuleId);
            cstmt.setString("AlgorithmName", algorithmSSS.getAlgorithmName());
            cstmt.setString("AlgorithmDescription", algorithmSSS.getAlgorithmDescription());
            cstmt.setString("Oid", algorithmSSS.getOid());
            cstmt.setBytes("BinOid", algorithmSSS.getBinOid());
            cstmt.setBytes("HashBin", algorithmSSS.getHashBin());
            cstmt.setBytes("AsymmBin", algorithmSSS.getAsymmBin());
            cstmt.registerOutParameter("AlgorithmSignId", Types.INTEGER);
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
                id = cstmt.getInt("AlgorithmSignId");
                System.out.println(returnMessage + ", Registro con el ID " + cstmt.getInt("AlgorithmSignId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        } finally {
            cstmt.close();

        }
        return id;
    }

    //Metodo que actualiza registros de la tabla AlgorithmSignSymm
    @Override
    public void save(AlgorithmSignSymm algorithmSSS, String userName, String hostName) throws Exception {
        sql = "{call  AlgorithmSignSymmSave(?,?,?,?,?,?)}";
        System.out.println("com.seguriboxltv.core.dao.impl.AlgorithmSignSymmDaoImpl.save() :"+algorithmSSS.getAlgorithmName() );
        try {
            conn = dataSource.getConnection();

            cstmt = conn.prepareCall(sql);
            
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            cstmt.setString("AlgorithmName", algorithmSSS.getAlgorithmName());
            cstmt.setString("AlgorithmDescription", algorithmSSS.getAlgorithmDescription());
            cstmt.setBoolean("IsActive", algorithmSSS.isIsActive());
            cstmt.executeQuery();
        } catch (SQLException e) {
            throw e;
        }catch(Exception e){
            throw e;
        }
    }

    //Metodo que obtiene un registro por id de la base de datos AlgorithmSignSymm 
    @Override
    public AlgorithmSignSymm Get(int algorithmId) throws Exception {

        sql = "{call AlgorithmSignSymmGet(?)}";
        AlgorithmSignSymm result = null;
        try {
            conn = dataSource.getConnection();

            cstmt = conn.prepareCall(sql);
            cstmt.setInt("AlgorithmId", algorithmId);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("El algoritmo  buscado no existe");
            } else {
                result = new AlgorithmSignSymm();
                result.setAlgorithmSignId(rsl.getInt("AlgorithmSignId"));
                result.setHashId(rsl.getInt("AlgorithmHashId"));
                result.setAssymetricId(rsl.getInt("AlgorithmAsymmetricId"));
                result.setCriptoModuleId(rsl.getShort("CryptoModuleId"));
                result.setDateReference(rsl.getDate("ReferenceDate"));
                result.setExpirationDate(rsl.getDate("ExpirationDate"));
                result.setAlgorithmName(rsl.getString("AlgorithmName"));
                result.setAlgorithmDescription(rsl.getString("AlgorithmDescription"));
                result.setOid(rsl.getString("Oid"));
                result.setBinOid(rsl.getBytes("BinOid"));
                result.setHashBin(rsl.getBytes("HashBin"));
                result.setAsymmBin(rsl.getBytes("AsymmBin"));
                // result.setActive;
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    //Metodo que obtiene todos los registros de la base de datos AlgorithmSignSymm
    @Override
    public List<AlgorithmSignSymm> GetAll() throws Exception {
        List<AlgorithmSignSymm> result = new ArrayList<>();
        try {
            conn = dataSource.getConnection();

            cstmt = conn.prepareCall("{call AlgorithmSignSymmGet(?)}");
            cstmt.setInt("AlgorithmId", 0);
            rsl = cstmt.executeQuery();
            while (rsl.next()) {
                AlgorithmSignSymm item = new AlgorithmSignSymm();
                item.setAlgorithmSignId(rsl.getInt("AlgorithmSignId"));
                item.setHashId(rsl.getInt("AlgorithmHashId"));
                item.setAssymetricId(rsl.getInt("AlgorithmAsymmetricId"));
                item.setCriptoModuleId(rsl.getShort("CryptoModuleId"));
                item.setDateReference(rsl.getDate("ReferenceDate"));
                item.setExpirationDate(rsl.getDate("ExpirationDate"));
                item.setAlgorithmName(rsl.getString("AlgorithmName"));
                item.setAlgorithmDescription(rsl.getString("AlgorithmDescription"));
                item.setOid(rsl.getString("Oid"));
                item.setBinOid(rsl.getBytes("BinOid"));
                item.setHashBin(rsl.getBytes("HashBin"));
                item.setAsymmBin(rsl.getBytes("AsymmBin"));
                item.setAsymetricName(rsl.getString("AsymetricName"));
                item.setHashName(rsl.getString("HashName"));
                item.setIsActive(rsl.getBoolean("IsActive"));
                
                result.add(item);
            }
        } catch (Exception e) {
            
            throw e;
        }
        return result;
    }

}
