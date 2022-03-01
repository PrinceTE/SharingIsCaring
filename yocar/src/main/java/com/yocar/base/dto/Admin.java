package com.yocar.base.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String adminEmail;
	private long adminPhone;
	private String password;
	private String adminRole;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "admin_car",referencedColumnName = "adminId")
//	private List<CarDetails> carDetails;
}