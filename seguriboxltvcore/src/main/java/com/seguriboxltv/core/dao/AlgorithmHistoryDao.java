/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao;

import com.seguriboxltv.core.domain.AlgorithmHistory;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author victor
 */
public interface AlgorithmHistoryDao {
    //public AlgorithmHistory Get(int EventId) throws Exception;
   // public List<AlgorithmHistory> GetAll() throws Exception;
    public List<AlgorithmHistory> Search(Date startDate, Date endDate, int userId) throws Exception;
    //public void Save(String userName,String hostName,AlgorithmHistory myAlgorithmHistory) throws Exception;
    
    
}
