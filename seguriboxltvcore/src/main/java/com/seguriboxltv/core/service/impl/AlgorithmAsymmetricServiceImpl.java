package com.seguriboxltv.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguriboxltv.core.dao.AlgorithmAsymmetricDao;
import com.seguriboxltv.core.domain.AlgorithmAsymmetric;
import com.seguriboxltv.core.service.AlgorithmAsymmetricService;

//Clase service que implementa los metodos que se crearon en la clase Dao AlgorithmAsymmetricDaoImpl
@Service
public class AlgorithmAsymmetricServiceImpl implements AlgorithmAsymmetricService {

	@Autowired
	private AlgorithmAsymmetricDao algorithmAsymmetricDao;
	
	public int Create(AlgorithmAsymmetric algorithmAsymmetric, int cryptoModuleId, String userName, String hostName) throws Exception {
		
		return algorithmAsymmetricDao.Create(algorithmAsymmetric, cryptoModuleId, userName, hostName);
	}

	@Override
	public void Save(int algorithmId, String userName, String hostName, String algorithmName,
			String algorithmDescription, int secure, boolean isActive) throws Exception {
		// TODO Auto-generated method stub
		algorithmAsymmetricDao.Save(algorithmId, userName, hostName, algorithmName, algorithmDescription, secure, isActive);
	}

	
	public AlgorithmAsymmetric GetById(int algorithmId) throws Exception {
		
		return algorithmAsymmetricDao.GetById(algorithmId);
	}

        @Override
	public List<AlgorithmAsymmetric> GetAll() throws Exception {
		 
		return algorithmAsymmetricDao.GetAll();
	}

}
