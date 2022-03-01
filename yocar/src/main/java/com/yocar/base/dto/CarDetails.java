package com.yocar.base.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class CarDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	private String carName;
	private String company;
	private String carFuelType;
	private boolean carPowerSteering;
	private String carBreakSystem;
	private double carShowroomPrice;
	private double carOnRoadPrice;
	private String carImageURL;
	private double carMileage;
	private int carSeatingCapacity;
	private int carEngineCapacity;
	private String carGearType;
	
	@ManyToOne
	@JoinColumn(name = "admin_id",referencedColumnName = "adminId")
	private Admin admin;
	
}