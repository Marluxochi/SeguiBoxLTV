/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.domain;

/**
 *
 * @author victor
 */
public class UserState {
    
    private String userId;
    private String userName;
    private short  StatusId;
    private String firstName;
    private String middleName;
    private String lastName;
    private short authenticationMode;
    private short userType;
    private String ipAddress;  

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public short getStatusId() {
        return StatusId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public short getAuthenticationMode() {
        return authenticationMode;
    }

    public short getUserType() {
        return userType;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    
    
}
