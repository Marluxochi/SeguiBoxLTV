/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.Hsmkey;
import com.seguriboxltv.core.service.HsmKeyService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author inggerman
 */
@Component
@ManagedBean
@RequestScoped
public class HsmKeyBean extends HsmKeyBeanBase {

    @Autowired
    private HsmKeyService hsmkeyservice;
    private DualListModel<Hsmkey> hsmkeys;
    List<Hsmkey> listTarget = new ArrayList<>();
    List<Hsmkey> list = null;

    public DualListModel<Hsmkey> getHsmkeys() {
        return hsmkeys;
    }

    public void setHsmkeys(DualListModel<Hsmkey> hsmkeys) {
        this.hsmkeys = hsmkeys;
    }

    @PostConstruct
    public void init() {
        try {
            list=hsmkeyservice.GetAll();
            hsmkeys = new DualListModel<>(list, listTarget);
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

    }

}
