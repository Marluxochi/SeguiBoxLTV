/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.User;
import com.seguriboxltv.core.service.UserService;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author victor
 */
public class BeanBase {

    private String un="gerhl92";

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }
    
    @Autowired
    private UserService userservice;

    public boolean ValidSession() {
        return true;
    }

    public User GetUser(String username) {

        User result = null;

        try {
            result = userservice.GetByUserName(username);
        } catch (Exception e) {
        }
        return result;
    }

    public boolean TaskValid(String userName, String taskName) {

        return false;
    }

    public String GetIp() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }
}
