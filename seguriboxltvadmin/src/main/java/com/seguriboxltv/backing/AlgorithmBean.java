/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AlgorithmSignSymm;
import com.seguriboxltv.core.service.AlgorithmSignSymmService;
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
public class AlgorithmBean extends AlgorihmBeanBase{
    
    @Autowired
    private AlgorithmSignSymmService algorithmSymSing;
    
    public List<AlgorithmSignSymm> getAllSymeSing(){
        List<AlgorithmSignSymm> list=null;
        
        try {
            list=algorithmSymSing.GetAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public String goToEdit(AlgorithmSignSymm algorithm){
    
        setAlgorithmSingSym(algorithm);
        return "adminAlgorithm";
    }
    
    public String update(){
        System.out.println("entro al update");
        try {
            algorithmSymSing.save(algorithmSingSym, "gerhl92", GetIp());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","El registro se actualizo correctamente"));
            return "adminAlgorithms";
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e.getMessage()));
            return null;
        }
        
        
    }
}
