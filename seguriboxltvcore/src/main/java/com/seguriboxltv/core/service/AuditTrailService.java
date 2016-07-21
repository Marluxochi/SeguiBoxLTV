/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service;

import com.seguriboxltv.core.domain.AuditTrail;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author IngGerman
 */
public interface AuditTrailService {
   public List<AuditTrail> Get(Date eventDate, byte CategoryCode, int EventCode, short pageNumber, short pages, int rows) throws Exception; 
}
