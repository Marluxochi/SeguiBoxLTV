/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service.impl;

import com.seguriboxltv.core.dao.AlgorithmHistoryDao;
import com.seguriboxltv.core.domain.AlgorithmHistory;
import com.seguriboxltv.core.service.AlgorithmHistoryService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victor
 */
@Service
public class AlgorithmHistoryServiceImpl implements AlgorithmHistoryService {
 @Autowired
        private AlgorithmHistoryDao algorithmHistoryDao; 
    @Override
    public List<AlgorithmHistory> Search(Date startDate, Date endDate, int userId) throws Exception {
       return algorithmHistoryDao.Search(startDate, endDate, userId);

    }
    
}
