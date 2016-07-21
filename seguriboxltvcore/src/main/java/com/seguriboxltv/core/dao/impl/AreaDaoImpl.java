package com.seguriboxltv.core.dao.impl;

import com.seguriboxltv.core.dao.AreaDao;
import com.seguriboxltv.core.domain.Area;
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

@Repository
public class AreaDaoImpl implements AreaDao {
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
    public List<Area> Get(int areaId) throws Exception {
        List<Area> result = new ArrayList<>();

        sql = "{call AreaGet(?)}";
        try {
            conn = dataSource.getConnection();
            cstmt=conn.prepareCall(sql);
            cstmt.setShort("AreaId", (short) areaId);
            rsl = cstmt.executeQuery();
            while (rsl.next()) {
                Area item = new Area();
                item.setAreaId(rsl.getShort("AreaId"));
                item.setAreaName(rsl.getString("AreaName"));
                item.setIsActive(rsl.getBoolean("IsActive"));
                item.setReferenceDate(rsl.getDate("ReferenceDate"));
                result.add(item);
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    @Override
    public Area GetById(int areaId) throws Exception {
        Area result = new Area();
        sql = "{call AreaGet(?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("AreaId", (short) areaId);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("No se ejecuto la consulta");
            } else {

                result = new Area();
                result.setAreaId(rsl.getShort("AreaId"));
                result.setAreaName(rsl.getString("AreaName"));
                result.setIsActive(rsl.getBoolean("IsActive"));
                result.setReferenceDate(rsl.getDate("ReferenceDate"));
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public int Save(Area myArea, String hostName, String userName) throws Exception {
        String sql = "{call AreaSave(?,?,?,?,?)}";
        int outParameter;
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("AreaId", (short)myArea.getAreaId());
            cstmt.registerOutParameter(1, Types.SMALLINT);
            cstmt.setString("AreaName", myArea.getAreaName());
            cstmt.setBoolean("IsActive", myArea.getIsActive());
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);

            boolean results = cstmt.execute();
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

            outParameter = cstmt.getShort(1);

        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }

        return outParameter;
    }

    @Override
    public int Delete(int areaId, String hostName, String userName) throws Exception {
        String sql = "{call AreaDelete(?,?,?)}";
        int outParameter;
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("AreaId", (short) areaId);
            cstmt.registerOutParameter(1, Types.SMALLINT);
            cstmt.setString("HostName", hostName);
            cstmt.setString("UserName", userName);
            boolean results = cstmt.execute();
            
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
                outParameter = cstmt.getShort(1);
           
        } catch (Exception e) {
            throw e;
        }
        return outParameter;
    }

}
