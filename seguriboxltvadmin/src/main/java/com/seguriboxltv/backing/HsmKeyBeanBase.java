/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.Hsmkey;


/**
 *
 * @author inggerman
 */
public class HsmKeyBeanBase extends BeanBase {

    Hsmkey hsmKey = new Hsmkey();
    
    public Hsmkey getHsmKey() {
        return hsmKey;
    }

    public void setHsmKey(Hsmkey hsmKey) {
        this.hsmKey = hsmKey;
    }

}
