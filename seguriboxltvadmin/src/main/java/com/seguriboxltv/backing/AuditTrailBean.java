/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AuditTrail;
import com.seguriboxltv.core.service.AuditTrailService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author IngGerman
 */
@Component
@ManagedBean
@RequestScoped
public class AuditTrailBean extends AuditTrailBeanBase{
    
    @Autowired
    private AuditTrailService auditTrailService;
    
    public List<AuditTrail> getAuditTrails(){
    
        try {
            //auditTrailService.Get(eventDate, 0, 0, 0, 0, 0);
        } catch (Exception e) {
        }
        return null;
        
    }
    
}
