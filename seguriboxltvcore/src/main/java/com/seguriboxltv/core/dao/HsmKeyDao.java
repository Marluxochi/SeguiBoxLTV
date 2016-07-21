/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao;

import com.seguriboxltv.core.domain.Hsmkey;
import com.seguridata.hsm.bean.HSMKey;
import java.util.List;

/**
 *
 * @author IngGerman
 */
public interface HsmKeyDao {

    public void Create(Hsmkey myHsmKey, String userName, String hostName) throws Exception;

    public List<Hsmkey> GetAll() throws Exception;

    public Hsmkey GetById(int hsmKeyId) throws Exception;

    public void Save(int hsmKeyId, boolean isActive, String userName, String hostName) throws Exception;

}
