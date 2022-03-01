package com.yocar.base.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yocar.base.dto.Admin;


public interface AdminDao extends CrudRepository<Admin,Integer> {
	
//	public Admin findByAdminId(int id);

	public Admin findByAdminName(String adminName);

}
