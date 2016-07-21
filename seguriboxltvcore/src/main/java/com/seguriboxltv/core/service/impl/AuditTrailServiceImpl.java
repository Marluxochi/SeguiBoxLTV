/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service.impl;

import com.seguriboxltv.core.dao.AuditTrailDao;
import com.seguriboxltv.core.domain.AuditTrail;
import com.seguriboxltv.core.service.AuditTrailService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author IngGerman
 */
@Service
public class AuditTrailServiceImpl implements AuditTrailService{

    @Autowired
    private AuditTrailDao auditTrailDao;
    
    @Override
    public List<AuditTrail> Get(Date eventDate, byte CategoryCode, int EventCode, short pageNumber, short pages, int rows) throws Exception {

        return auditTrailDao.Get(eventDate, CategoryCode, EventCode, pageNumber, pages, rows);
    }
    
}
