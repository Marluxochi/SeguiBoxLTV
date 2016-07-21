/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.User;
import com.seguriboxltv.core.service.UserService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ing German
 */
@Component
@ManagedBean
@RequestScoped
public class UserBean extends UserBeanBase{

    
    @Autowired
    private UserService userService;


    public String holas() {
        return "exito";
    }
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().remove("alias");
        return "signin";
        
    }
    public String validarUsuario() {
     int userValidation;
        String username = user.getUsername();
        String password = user.getPassword();
        String hostName = "MAQ-1";
        String resultado = "";
        try{
         userValidation= userService.MembershipValidateUser(username, password, hostName);
        if (userValidation == 0) {
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().put("alias", this.user);
            resultado = "ejemploMaster";
        } else {
            resultado = "ErrorNA";
        }
        }catch(Exception e){
            
        }
        return resultado;
    }
    public String VerificarDatos() {
        int userValidation = 0;
        String username = "mike";
        String password = "mike";
        String hostName = "MAQ-1";
        String resultado = "";

        //  userValidation= userService.MembershipValidateUser(username, password, hostName);
        if (userValidation == 0) {
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().put("alias", this.user);
            resultado = "Exito";
        } else {
            resultado = "Error";
        }

        return resultado;
    }
    public void create(){
    
        try {
            userService.Create(user, GetIp(),getUn());
            user=new User();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    

}
