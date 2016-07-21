package com.seguriboxltv.core.service;

import java.util.List;

import com.seguriboxltv.core.domain.AlgorithmAsymmetric;

public interface AlgorithmAsymmetricService {
	public int Create(AlgorithmAsymmetric algorithmAsymmetric, int cryptoModuleId, String userName, String hostName) throws Exception;
	
	public void Save(int algorithmId, String userName, String hostName, String algorithmName,
			String algorithmDescription, int secure, boolean isActive) throws Exception;
	public AlgorithmAsymmetric GetById(int algorithmId) throws Exception;
	public List<AlgorithmAsymmetric> GetAll() throws Exception;
}
