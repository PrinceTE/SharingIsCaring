package com.yocar.base.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yocar.base.dao.AdminDao;
import com.yocar.base.dto.Admin;
import com.yocar.base.dto.AdminDetails;

@Service
public class AdminServiceImpl implements UserDetailsService {
	
	@Autowired
	private AdminDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin=dao.findByAdminName(username);
		if(admin!=null) {
		//	return new AdminDetails(admin);
			return new User(admin.getAdminName(), admin.getPassword(), new ArrayList<>());
			
		}
		throw new UsernameNotFoundException("Admin not found");
	}

}
