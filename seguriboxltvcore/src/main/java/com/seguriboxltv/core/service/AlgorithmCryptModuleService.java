package com.seguriboxltv.core.service;

import java.util.List;

import com.seguriboxltv.core.domain.AlgorithmCryptModule;
import com.seguriboxltv.core.domain.AlgorithmHash;
import com.seguridata.crypto.bean.AssymetricAlgs;
import com.seguridata.crypto.bean.HashAlgs;
import com.seguridata.crypto.bean.SymmetricAlgs;

public interface AlgorithmCryptModuleService {

    public int Create(String userName, String hostName) throws Exception;

    public List<AlgorithmCryptModule> GetAll() throws Exception;

    public AlgorithmCryptModule GetbyId(int id) throws Exception;

    public List<HashAlgs> GetSDAlgorithmHash() throws Exception;

    public List<AssymetricAlgs> GetSDAssymetricAlgs() throws Exception;

    public List<SymmetricAlgs> GetSDSymmetricAlgs() throws Exception;

}
