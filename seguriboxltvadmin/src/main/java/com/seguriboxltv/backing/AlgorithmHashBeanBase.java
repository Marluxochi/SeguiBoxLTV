/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AlgorithmHash;

/**
 *
 * @author inggerman
 */
public class AlgorithmHashBeanBase extends BeanBase {
    
    AlgorithmHash algortihmHash=new AlgorithmHash();

    public AlgorithmHash getAlgortihmHash() {
        return algortihmHash;
    }

    public void setAlgortihmHash(AlgorithmHash algortihmHash) {
        this.algortihmHash = algortihmHash;
    }
    
    
    
}
