/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao.impl;

import com.seguriboxltv.core.dao.AuditTrailDao;
import com.seguriboxltv.core.domain.AuditTrail;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author IngGerman
 */
@Repository
public class AuditTrailDaoImpl implements AuditTrailDao{

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
    public List<AuditTrail> Get(Date eventDate, byte CategoryCode, int EventCode, short pageNumber, short pages, int rows) throws Exception {
        
        sql = "{call AuditTrailGet(?,?,?,?,?,?,?)}";
        List<AuditTrail> list =new ArrayList<>();
        try {
            conn=dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setDate("EventDate", Date.valueOf("2016-11-04"));
            cstmt.setByte("CategoryCode", CategoryCode);
            cstmt.setInt("EventCode", EventCode);
            cstmt.setShort("PageSize", pages);
            rsl = cstmt.executeQuery();
            
            while(rsl.next()){
            
                AuditTrail auditTrail=new AuditTrail();
                auditTrail.setEventDate(rsl.getDate("EventDate"));
                auditTrail.setEventCode(rsl.getShort("EventCode"));
                auditTrail.setUserHostIp(rsl.getString("UserHostIP"));
                auditTrail.setFullUserName(rsl.getString("FullNameUser"));
                auditTrail.setObjectName(rsl.getString("ObjectName"));
                auditTrail.setObjectId(rsl.getInt("ObjectId"));
                auditTrail.setInstanceName(rsl.getString("InstanceName"));
                auditTrail.setNotes(rsl.getString("Notes"));
                
                list.add(auditTrail);
            }
            
            
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return list;
    }
    
}
