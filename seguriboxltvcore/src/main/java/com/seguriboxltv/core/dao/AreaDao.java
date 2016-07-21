/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao;

import com.seguriboxltv.core.domain.Area;
import java.util.List;

public interface AreaDao {
    public List<Area> Get(int areaId) throws Exception;
    public Area GetById(int areaId) throws Exception;
    public int Save(Area myArea,String hostName,String userName)throws Exception;
    public int Delete(int groupId, String hostName, String userName) throws Exception;
}
