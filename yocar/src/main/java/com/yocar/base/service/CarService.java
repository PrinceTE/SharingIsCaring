package com.yocar.base.service;

import java.util.List;

import com.yocar.base.dto.CarDetails;

public interface CarService {
	
	public List<CarDetails> getAllCar();
	public boolean addCar(CarDetails carDetails);
	public boolean deleteCar(int id);
	public boolean updateCar(CarDetails carDetails);

}
