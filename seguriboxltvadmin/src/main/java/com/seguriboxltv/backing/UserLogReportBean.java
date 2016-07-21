/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author victor
 */
@Component
@ManagedBean
@RequestScoped
public class UserLogReportBean extends UserLogReportBeanBase {
        
        public UserLogReportBean(){
            if(this.ValidSession()==false){
                
            }
            //if(this.GetUser("mike")){
            
          //  }
        }
}
