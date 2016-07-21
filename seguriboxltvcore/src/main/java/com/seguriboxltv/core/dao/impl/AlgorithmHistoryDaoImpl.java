/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao.impl;

import com.seguriboxltv.core.dao.AlgorithmHistoryDao;
import com.seguriboxltv.core.domain.AlgorithmHistory;
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

@Repository
public class AlgorithmHistoryDaoImpl implements AlgorithmHistoryDao {

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
    public List<AlgorithmHistory> Search(Date startDate, Date endDate, int userId) throws Exception {
        List<AlgorithmHistory> result = new ArrayList<>();

        try {
            conn=dataSource.getConnection();
            cstmt = conn.prepareCall("{call AlgorithmHistorySearch(?,?,?)}");
            cstmt.setDate(1, startDate);
            cstmt.setDate(2, endDate);
            cstmt.setInt("UserId", userId);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("No hay registros en la tabla");
            } else {
                while (rsl.next()) {
                    AlgorithmHistory item = new AlgorithmHistory();
                    item.setEventId(rsl.getInt("EventId"));
                    item.setDateReference(rsl.getDate("ReferenceDate"));
                    item.setUserId(rsl.getInt("UserId"));
                    item.setHostName(rsl.getString("HostName"));
                    item.setAction(rsl.getString("Action"));
                    item.setDetails(rsl.getString("Details"));
                    result.add(item);
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

}


