/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author IngGerman
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    
    
    @Autowired
    private User user;
    
    @Autowired
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public String Login(){
    
        
        
        return "";
    }
    
}
