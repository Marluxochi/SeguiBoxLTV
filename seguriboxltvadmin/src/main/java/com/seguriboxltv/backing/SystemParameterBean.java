/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.SystemParameter;
import com.seguriboxltv.core.service.SystemParameterService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author IngGerman
 */
@Component
@ManagedBean
@RequestScoped
public class SystemParameterBean {
    
    @Autowired
    private SystemParameterService systemPServ;
    
    SystemParameter systemP=new SystemParameter();
    
   
    public SystemParameter getSystemP() {
        return systemP;
    }

    public void setSystemP(SystemParameter systemP) {
        this.systemP = systemP;
    }
    
    
    
    public void save(){
        
        
        
        try {
            systemPServ.Set(systemP, GetIp(), "gerhl92");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private  String GetIp() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        
        return ipAddress;
    }
}
