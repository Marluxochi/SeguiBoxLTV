package com.seguriboxltv.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguriboxltv.core.dao.AlgorithmAsymmetricDao;
import com.seguriboxltv.core.dao.AlgorithmCryptModuleDao;
import com.seguriboxltv.core.dao.AlgorithmHashDao;
import com.seguriboxltv.core.dao.AlgorithmSignSymmDao;
import com.seguriboxltv.core.domain.AlgorithmAsymmetric;
import com.seguriboxltv.core.domain.AlgorithmCryptModule;
import com.seguriboxltv.core.domain.AlgorithmHash;
import com.seguriboxltv.core.domain.AlgorithmSignSymm;
import com.seguriboxltv.core.service.AlgorithmCryptModuleService;
import com.seguridata.crypto.CryptoModule;
import com.seguridata.crypto.bean.AssymetricAlgs;
import com.seguridata.crypto.bean.HashAlgs;
import com.seguridata.crypto.bean.SymmetricAlgs;
import com.seguridata.crypto.sdexception.SDException;
import java.sql.SQLException;

@Service
public class AlgorithmCryptModuleServiceImpl implements AlgorithmCryptModuleService {

    private final CryptoModule cryptoModule = new CryptoModule();
    @Autowired
    private  AlgorithmCryptModuleDao algorithmCryptModuleDao;
    @Autowired
    private   AlgorithmAsymmetricDao algorithmAsymmetricDao;
    @Autowired
    private  AlgorithmHashDao algorithmHashDao;
    @Autowired
    private  AlgorithmSignSymmDao algorithmSignSymmDao;
   

    @Override
    public int Create(String userName, String hostName) throws Exception {
        int assymetricId = 0;
        int hashId = 0;
        int cryptoModuleId = 0;
        try {
            cryptoModuleId = algorithmCryptModuleDao.Create(userName, hostName);
            System.out.println("cryptomoduleid:"+cryptoModuleId);

            if (cryptoModuleId == 0) {

                throw new Exception("No retorno OUT parameter");
            } else {
                System.err.println("entro al elseasdsadasd");
                System.out.println("entro al elseasdsadasd");
                System.out.println("entro al elseasdsadasd");
                hashId = CreateHash(cryptoModule.getHashAlgs(), cryptoModuleId, userName, hostName);
                assymetricId = CreateAssymetric(cryptoModule.getAssymetricAlgs(), cryptoModuleId, userName, hostName);
                

                if (assymetricId > 0 && hashId > 0) {

                    CreateSingSymm(cryptoModule.getSymmetricAlgs(), cryptoModuleId, userName, hostName, assymetricId, hashId);
                } else {

                    throw new Exception("Se produjo un error");
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return cryptoModuleId;
    }

    @Override
    public List<AlgorithmCryptModule> GetAll() throws Exception {
        // TODO Auto-generated method stub
        return algorithmCryptModuleDao.GetAll();
    }

    @Override
    public AlgorithmCryptModule GetbyId(int id) throws Exception {
        // TODO Auto-generated method stub
        return algorithmCryptModuleDao.GetbyId(id);
    }

    //Metodo que recupera la lista de HashAlgs de la API de seguriData
    @Override
    public List<HashAlgs> GetSDAlgorithmHash() throws SDException {
        return new CryptoModule().getHashAlgs();
    }


    //Metodo que recupera la lista de AssymetricAlgs de la API de seguriData
    @Override
    public List<AssymetricAlgs> GetSDAssymetricAlgs() throws SDException {

        return new CryptoModule().getAssymetricAlgs();
    }

    //Metodo que recupera la lista de SymmetricAlgs de la API de seguriData
    @Override
    public List<SymmetricAlgs> GetSDSymmetricAlgs() throws SDException {

        return new CryptoModule().getSymmetricAlgs();
    }

    private  int CreateAssymetric(List<AssymetricAlgs> algorithms, int cryptoModuleId, String userName, String hostName)
            throws Exception {
        
        int id = 0;
        try {
            for (AssymetricAlgs item : algorithms) {
                AlgorithmAsymmetric algorithmAsymmetric = new AlgorithmAsymmetric();
                // algorithmAsymmetric.setAlgorithmAsymmetricId(0);
                algorithmAsymmetric.setAlgorithmName(item.getName());
                algorithmAsymmetric.setAlgorithmDescription("Detalles");
                algorithmAsymmetric.setOid(item.getStrOId());
                algorithmAsymmetric.setBinOid(item.getBinOId());
                algorithmAsymmetric.setMinBits(item.getMinBits());
                algorithmAsymmetric.setMaxBits(item.getMaxBits());
                algorithmAsymmetric.setDeltaBits(item.getDeltaBits());
                algorithmAsymmetric.setMinSecureBits(item.getMinSecurebits());
                algorithmAsymmetric.setSecure(item.getSecure());
                id = algorithmAsymmetricDao.Create(algorithmAsymmetric, cryptoModuleId, userName, hostName);
            }
        } catch (Exception e) {

            throw e;

        }
        return id;
    }

    private  int CreateHash(List<HashAlgs> algorithms, int cryptoModuleId, String userName, String hostName)
            throws Exception {
        System.out.println("com.seguriboxltv.core.service.impl.AlgorithmCryptModuleServiceImpl.CreateHash()"+algorithms+"-"+cryptoModuleId+"-"+userName+"-"+hostName);
        int id = 0;
        try {
            for (HashAlgs item : algorithms) {

                AlgorithmHash algorithmHash = new AlgorithmHash();

                algorithmHash.setAlgorithmHashId(0);
                algorithmHash.setCriptoModuleId((short) cryptoModuleId);
                algorithmHash.setAlgorithmName(item.getName());
                algorithmHash.setAlgorithmDescription("Description");
                algorithmHash.setOid(item.getStrOId());
                algorithmHash.setBinOid(item.getBinOId());
                algorithmHash.setBits(item.getBits());
                algorithmHash.setBytes(item.getBytes());
                algorithmHash.setSecure(item.getSecure());
                id = algorithmHashDao.Create(algorithmHash, cryptoModuleId, userName, hostName);
            }
        } catch (SDException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }

        return id;
    }

    private  void CreateSingSymm(List<SymmetricAlgs> algorithms, int cryptoModuleId, String userName,
            String hostName, int assymetricId, int hashId)
            throws Exception {
        int id = 0;
        try {

            for (SymmetricAlgs item : algorithms) {

                AlgorithmSignSymm algorithmSignSymm = new AlgorithmSignSymm();

                algorithmSignSymm.setAlgorithmName(item.getName());
                algorithmSignSymm.setAlgorithmDescription("Description");
                algorithmSignSymm.setOid(item.getStrOId());
                algorithmSignSymm.setBinOid(item.getBinOId());
                algorithmSignSymm.setHashBin(item.getHashBinAlg());
                algorithmSignSymm.setAsymmBin(item.getAsymmBinAlg());
                algorithmSignSymm.setAssymetricId(assymetricId);
                algorithmSignSymm.setHashId(hashId);
                id = algorithmSignSymmDao.create(algorithmSignSymm, cryptoModuleId, userName, hostName, assymetricId, hashId);

            }

        } catch (Exception e) {

            throw e;
        }
    }

}
