/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.stereotype.Component;

/**
 *
 * @author IngGerman
 */
@Component
@ManagedBean
@RequestScoped
public class ReportUserBean extends ReportUserBeanBase{
    
    
    public String create(){
    
        if(this.ValidSession()==false){
            
            return "signin";
        }else{
        
            if(this.TaskValid("german", "reportUsers")==false){
                
                return "errorMesaage";
            }
            return null;
        }
    }
    
}
