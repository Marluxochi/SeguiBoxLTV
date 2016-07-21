/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao;

import com.seguriboxltv.core.domain.Pais;
import java.util.List;

/**
 *
 * @author IngGerman
 */
public interface PaisDao {
 
    public List<Pais> GetAll() throws Exception;
    
    public Pais Get() throws Exception;
    
    
}
