/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AlgorithmSignSymm;

/**
 *
 * @author inggerman
 */
public class AlgorihmBeanBase extends BeanBase{
    
    AlgorithmSignSymm algorithmSingSym=new AlgorithmSignSymm();

    public AlgorithmSignSymm getAlgorithmSingSym() {
        return algorithmSingSym;
    }

    public void setAlgorithmSingSym(AlgorithmSignSymm algorithmSingSym) {
        this.algorithmSingSym = algorithmSingSym;
    }
    
    
}
