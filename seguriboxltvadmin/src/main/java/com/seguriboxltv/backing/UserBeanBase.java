/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.User;

/**
 *
 * @author IngGerman
 */
public class UserBeanBase extends BeanBase {

    public User user = new User();

    public User getUser() {
        return user;
    }

    public void setuUser(User usuario) {
        this.user = usuario;
    }

}
