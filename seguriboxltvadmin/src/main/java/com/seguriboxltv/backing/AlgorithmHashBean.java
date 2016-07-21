/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AlgorithmHash;
import com.seguriboxltv.core.service.AlgorithmHashService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author inggerman
 */
@Component
@ManagedBean
@RequestScoped
public class AlgorithmHashBean extends AlgorithmHashBeanBase{
    
    @Autowired
    AlgorithmHashService algorithmHashService;
    
    public List<AlgorithmHash> getHashes(){
    
        List<AlgorithmHash> list=null;
        try {
            list=algorithmHashService.GetAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public String goToEdit(AlgorithmHash algorithmHas){
    
        setAlgortihmHash(algorithmHas);
    
        System.out.println("valor de ah:"+algorithmHas.toString()+"hola como esytas");
        
        return "adminHashAlgorithm";
    }
    
    public String update(){
    
        try {
            System.out.println("esto es el valor del active:"+algortihmHash.isActive());
            algorithmHashService.Save(algortihmHash.getAlgorithmHashId(), "gerhl92",GetIp(), algortihmHash.getAlgorithmName(), algortihmHash.getAlgorithmDescription(), algortihmHash.getSecure(), algortihmHash.isActive());
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Registro actualizado correctamente"));
            return "adminHashAlgorithms";
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage()));
            return null;
        }
    
        
    }
    
}
