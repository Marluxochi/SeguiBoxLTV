package com.seguriboxltv.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguriboxltv.core.dao.AlgorithmSignSymmDao;
import com.seguriboxltv.core.domain.AlgorithmSignSymm;
import com.seguriboxltv.core.service.AlgorithmSignSymmService;

//Clase service que implementa los metodos que se crearon en la clase Dao AlgorithmSignSymm
@Service
public class AlgorithmSignSymmServiceImpl implements AlgorithmSignSymmService {
	@Autowired
	AlgorithmSignSymmDao algorithmSignSymmDao;

	public void create(AlgorithmSignSymm algorithmSSS, int cryptoModuleId, String userName, String hostName) throws Exception {
		
		algorithmSignSymmDao.create(algorithmSSS, cryptoModuleId, userName, hostName, cryptoModuleId, cryptoModuleId);
	}


	public void save(AlgorithmSignSymm algorithmSSS, String userName, String hostName) throws Exception {
		
		algorithmSignSymmDao.save(algorithmSSS, userName, hostName);
	}

	
	public AlgorithmSignSymm Get(int algorithmId) throws Exception {
		// TODO Auto-generated method stub
		return algorithmSignSymmDao.Get(algorithmId);
	}

	
	public List<AlgorithmSignSymm> GetAll() throws Exception {
		// TODO Auto-generated method stub
		return algorithmSignSymmDao.GetAll();
	}

}
