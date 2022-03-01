package com.yocar.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yocar.base.dao.CarDetailsDao;
import com.yocar.base.dto.CarDetails;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDetailsDao dao;

	@Override
	public List<CarDetails> getAllCar() {
		List<CarDetails> details = (List<CarDetails>) dao.findAll();
		if (details.size() <= 0) {
			return null;
		} else {
			return details;
		}
	}

	@Override
	public boolean addCar(CarDetails carDetails) {
		boolean isAdded = false;
		CarDetails carDetails2 = dao.save(carDetails);
		if (carDetails2 != null) {
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public boolean deleteCar(int id) {
		boolean isDeleted = false;
		CarDetails details = dao.findByCarId(id);
		if (details != null) {
			dao.delete(details);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public boolean updateCar(CarDetails carDetails) {
		boolean isUpdated = false;
		CarDetails details = dao.findByCarId(carDetails.getCarId());
		if (details != null) {
			details.setCarId(carDetails.getCarId());
			details.setCarName(carDetails.getCarName());
			details.setCompany(carDetails.getCompany());
			details.setCarFuelType(carDetails.getCarFuelType());
			details.setCarPowerSteering(carDetails.isCarPowerSteering());
			details.setCarBreakSystem(carDetails.getCarBreakSystem());
			details.setCarShowroomPrice(carDetails.getCarShowroomPrice());
			details.setCarOnRoadPrice(carDetails.getCarOnRoadPrice());
			details.setCarImageURL(carDetails.getCarImageURL());
			details.setCarMileage(carDetails.getCarMileage());
			details.setCarSeatingCapacity(carDetails.getCarSeatingCapacity());
			details.setCarEngineCapacity(carDetails.getCarEngineCapacity());
			details.setCarGearType(carDetails.getCarGearType());
		
			isUpdated = true;
		}
		return isUpdated;
	}

}
