package com.seguriboxltv.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguriboxltv.core.dao.CarDao;
import com.seguriboxltv.core.domain.Car;
import com.seguriboxltv.core.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao cardao;
	
	
        @Override
	public List<Car> getCarDetails() {
		
		System.out.println("hola desde el service: "+cardao.getCarDetails().size());
		return cardao.getCarDetails();
	}

}
