/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AuditTrail;

/**
 *
 * @author IngGerman
 */
public class AuditTrailBeanBase extends BeanBase{
    
    private AuditTrail auditTrail=new AuditTrail();

    public AuditTrail getAuditTrail() {
        return auditTrail;
    }

    public void setAuditTrail(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }
    
    
}
