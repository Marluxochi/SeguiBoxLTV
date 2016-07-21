/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.service.impl;

import com.seguriboxltv.core.dao.HsmKeyDao;
import com.seguriboxltv.core.domain.Hsmkey;
import com.seguriboxltv.core.service.HsmKeyService;
import com.seguridata.hsm.SDHSMKeys;
import com.seguridata.hsm.bean.HSMKey;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author IngGerman
 */
//Clase service que implementa los metodos que se crearon en la clase Dao HsmKey
@Service
public class HsmKeyServiceImpl implements HsmKeyService{

    @Autowired
    HsmKeyDao hsmKeyDao;
    
    @Override
    public void Create(Hsmkey myHsmKey, String userName, String hostName) throws Exception {

        hsmKeyDao.Create(myHsmKey, userName, hostName);
    }

    @Override
    public List<Hsmkey> GetAll() throws Exception {


        return hsmKeyDao.GetAll();
    }

    //Metodo que recupera la lista de Hsmkey de la API de seguriData
    @Override
    public Hsmkey GetById(int hsmKeyId) throws Exception {
    
        return hsmKeyDao.GetById(hsmKeyId);
    }

    @Override
    public void Save(int hsmKeyId, boolean isActive, String userName, String hostName) throws Exception {
        
        hsmKeyDao.Save(hsmKeyId, isActive, userName, hostName);
    }

    @Override
    public List<HSMKey> SDGetAll() throws Exception {
        return new SDHSMKeys().getHSMKeys();
    }
    
}
