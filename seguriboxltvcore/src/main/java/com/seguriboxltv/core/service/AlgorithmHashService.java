package com.seguriboxltv.core.service;

import java.util.List;

import com.seguriboxltv.core.domain.AlgorithmHash;

public interface AlgorithmHashService {
	public void Create(AlgorithmHash algorithmHash, int cryptoModuleId, String userName, String hostName)throws Exception;

	public void Save(int algorithmId, String userName, String hostName, String algorithmName,
			String algorithmDescription, int secure, boolean isActive)throws Exception;

	public AlgorithmHash GetById(int algorithmId)throws Exception;

	public List<AlgorithmHash> GetAll()throws Exception;
}
