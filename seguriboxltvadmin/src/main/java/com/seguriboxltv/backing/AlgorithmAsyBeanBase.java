/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AlgorithmAsymmetric;

/**
 *
 * @author IngGerman
 */
public class AlgorithmAsyBeanBase extends BeanBase{
    
    private AlgorithmAsymmetric algorihmAsy = new AlgorithmAsymmetric();

    public AlgorithmAsymmetric getAlgorihmAsy() {
        return algorihmAsy;
    }

    public void setAlgorihmAsy(AlgorithmAsymmetric algorihmAsy) {
        this.algorihmAsy = algorihmAsy;
    }
    
    
}
