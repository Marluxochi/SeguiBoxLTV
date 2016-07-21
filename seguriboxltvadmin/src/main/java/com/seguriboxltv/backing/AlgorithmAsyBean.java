/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AlgorithmAsymmetric;
import com.seguriboxltv.core.service.AlgorithmAsymmetricService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author IngGerman
 */
@Component
@ManagedBean
@RequestScoped
public class AlgorithmAsyBean extends AlgorithmAsyBeanBase {

    @Autowired
    private AlgorithmAsymmetricService algorithmAsymmetricService;

    public List<AlgorithmAsymmetric> getAllAsymetric() {
        List<AlgorithmAsymmetric> list = null;
        try {
            list = algorithmAsymmetricService.GetAll();
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage()));
        }
        return list;
    }
    
    public String goToEdit(AlgorithmAsymmetric algortithmAsy){
    
        System.out.println("entro al edit");
        this.setAlgorihmAsy(algortithmAsy);
    
        
        
        return "adminAsimetricAlgorithm";
    }
    
    public String update(int id,String algorithmName,String algorithmDes,int secure,boolean isActive){
        System.out.println("entro al update");
        try {
            algorithmAsymmetricService.Save(id, "gerhl92",GetIp(), algorithmName, algorithmDes, secure, isActive);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","El registro se actualizo correctamente"));
            
            
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage()));
           
            
        }
        return "adminAsimetricAlgorithms";
    }
}
