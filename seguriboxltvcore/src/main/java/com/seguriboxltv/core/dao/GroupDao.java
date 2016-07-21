/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao;

import com.seguriboxltv.core.domain.Group;
import com.seguriboxltv.core.domain.User;
import java.util.List;

/**
 *
 * @author IngGerman
 */
public interface GroupDao {
    
   public int Save(Group myGroup, String hostName, String userName) throws Exception;

    public void Delete(int groupId, String hostName, String userName) throws Exception;

    public Group GetByName(String groupName) throws Exception;

    public List<Group> Get(int groupId) throws Exception;

    public Group GetById(int groupId) throws Exception;

    public List<User> GetUsers(int groupId) throws Exception;

    public void AddTask(int groupId, int TaskId, String invokedBy, String hostIp) throws Exception;

    public void RemoveTask(int groupId, int TaskId, String invokedBy, String hostIp) throws Exception;

    public void AddUser(int groupId, String userName, String invokedBy, String hostIp) throws Exception;

    public void RemoveUser(int groupId, String userName, String invokedBy, String hostIp) throws Exception;
    
    public void addHsmKey(int groupId, int hsmkeyId, String userName, String hostName) throws Exception;
      
    public void RemoveHsmKey(int groupId, int hsmkeyId, String userName, String hostName) throws Exception;  
}   
