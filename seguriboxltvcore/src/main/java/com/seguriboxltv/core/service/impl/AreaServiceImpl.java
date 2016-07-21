package com.seguriboxltv.core.service.impl;

import com.seguriboxltv.core.dao.AreaDao;
import com.seguriboxltv.core.domain.Area;
import com.seguriboxltv.core.service.AreaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> Get(int areaId) throws Exception {
          return  areaDao.Get(areaId);
    }

    @Override
    public int  Save(Area myArea, String hostName, String userName) throws Exception {
        return areaDao.Save(myArea, hostName, userName);
    }

    @Override
    public int Delete(int groupId, String hostName, String userName) throws Exception {
        return areaDao.Delete(groupId, hostName, userName);
    }

    @Override
    public Area GetById(int areaId) throws Exception {
        return  areaDao.GetById(areaId);
    }

}

