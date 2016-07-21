package com.seguriboxltv.core.service;

import com.seguriboxltv.core.domain.Area;
import java.util.List;

public interface AreaService {

    public List<Area> Get(int areaId) throws Exception;

    public Area GetById(int areaId) throws Exception;

    public int Save(Area myArea, String hostName, String userName) throws Exception;

    public int Delete(int groupId, String hostName, String userName) throws Exception;

}
