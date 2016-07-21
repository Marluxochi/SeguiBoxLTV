/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service.impl;


import com.seguriboxltv.core.dao.GroupDao;
import com.seguriboxltv.core.domain.Group;
import com.seguriboxltv.core.domain.User;
import com.seguriboxltv.core.service.GroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author IngGerman
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public int Save(Group myGroup, String hostName, String userName) throws Exception {
       return groupDao.Save(myGroup, hostName, userName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int groupId, String hostName, String userName) throws Exception {
        groupDao.Delete(groupId, hostName, userName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Group GetByName(String groupName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Group> Get(int groupId) throws Exception {
        return groupDao.Get(groupId);
    }

    @Override
    public Group GetById(int groupId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> GetUsers(int groupId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddTask(int groupId, int TaskId, String invokedBy, String hostIp) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RemoveTask(int groupId, int TaskId, String invokedBy, String hostIp) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddUser(int groupId, String userName, String invokedBy, String hostIp) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RemoveUser(int groupId, String userName, String invokedBy, String hostIp) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addHsmKey(int groupId, int hsmkeyId, String userName, String hostName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RemoveHsmKey(int groupId, int hsmkeyId, String userName, String hostName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
