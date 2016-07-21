/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.Group;
import com.seguriboxltv.core.service.GroupService;
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
public class GroupBean extends GroupBaseBean{

    @Autowired
    private GroupService groupService;



    public String delete(Group group) {
        System.out.println("no tengo ni idea" + group.getGroupId());

        try {
            groupService.Delete(group.getGroupId(), GetIp(), "gerhl92");
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    public void save() {
        System.out.println("valores de grupos " +getGroup().toString());
        System.out.println("valores de ip " + GetIp());
        try {
            groupService.Save(getGroup(), GetIp(), "gerhl92");
            if (this.isEdit() == true) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El Grupo " + getGroup().getGroupName() + " fue ACTUALIZADO satisfactoriamente"));

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El Grupo " + getGroup().getGroupName() + " fue agregado satisfactoriamente"));

            }
            setGroup(new Group());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.getMessage()));
            e.printStackTrace();
        }
    }

    public List<Group> getGroups() {
        List<Group> list = null;
        try {
            list = groupService.Get(0);
            for(Group item:list){
                System.out.println("el valore es el siguiente omg:"+item.getProfileTypeStr());
                System.out.println("item to string:"+item.toString());
            }
           
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El area fue agregado satisfactoriamente"));

        }
        return list;
    }

    public String goToEdit(Group group) {
        System.out.println("entro a goto edit");
        setGroup(group);
        setEdit(true);
        System.out.println("grupo values:"+getGroup().toString());
        return "adminGroup";

    }
    
    public String getLabelMessage() {

        if (isEdit() == true) {

            setLabel("Editar");
            setEdit(false);
        } else {
            setLabel("Agregar");
            setGroup(new Group());
        }

        return getLabel();

    }
    
    

}
