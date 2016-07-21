package com.seguriboxltv.core.dao;

import java.util.List;

import com.seguriboxltv.core.domain.AlgorithmCryptModule;


public interface AlgorithmCryptModuleDao {

	public int Create(String userName, String hostName) throws Exception;
	public List<AlgorithmCryptModule> GetAll() throws Exception;
	public AlgorithmCryptModule GetbyId(int id) throws Exception;
	
}
