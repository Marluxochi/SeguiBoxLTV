package com.seguriboxltv.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguriboxltv.core.dao.AlgorithmHashDao;
import com.seguriboxltv.core.domain.AlgorithmHash;
import com.seguriboxltv.core.service.AlgorithmHashService;

//Clase service que implementa los metodos que se crearon en la clase Dao AlgorithmAsymmetric
@Service
public class AlgorithmHashServiceImpl implements AlgorithmHashService {
	@Autowired
	AlgorithmHashDao algorithmHashDao;
	
	
	public void Create(AlgorithmHash algorithmHash, int cryptoModuleId, String userName, String hostName) throws Exception {
		
		algorithmHashDao.Create(algorithmHash, cryptoModuleId, userName, hostName);
		
	}

	
	public void Save(int algorithmId, String userName, String hostName, String algorithmName,
			String algorithmDescription, int secure, boolean isActive) throws Exception {
		algorithmHashDao.Save(algorithmId, userName, hostName, algorithmName, algorithmDescription, secure, isActive);
		
	}

	
	public AlgorithmHash GetById(int algorithmId) throws Exception {
		
		return algorithmHashDao.GetById(algorithmId);
	}

	
	public List<AlgorithmHash> GetAll() throws Exception {
		
		return algorithmHashDao.GetAll();
	}

}
