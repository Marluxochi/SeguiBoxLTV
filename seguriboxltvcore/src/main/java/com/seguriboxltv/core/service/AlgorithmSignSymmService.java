package com.seguriboxltv.core.service;

import java.util.List;

import com.seguriboxltv.core.domain.AlgorithmSignSymm;

public interface AlgorithmSignSymmService {

	public void create(AlgorithmSignSymm algorithmSSS, int cryptoModuleId, String userName, String hostName)throws Exception;

	public void save(AlgorithmSignSymm algorithmSSS, String userName, String hostName)throws Exception;

	public AlgorithmSignSymm Get(int algorithmId)throws Exception;

	public List<AlgorithmSignSymm> GetAll()throws Exception;
}
