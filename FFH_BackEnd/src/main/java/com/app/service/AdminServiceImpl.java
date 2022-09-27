package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AdminRepository;
import com.app.dao.OrderRepository;
import com.app.pojos.Admin;
import com.app.pojos.Orders;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Admin authenticateAdmin(String email, String pwd) {

		return adminRepo.findByEmailAndPassword(email, pwd)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials..!!"));
	}

	@Override
	public List<Orders> getAllOrders() {
		System.out.println("In AdminServiceImpl ");
		return orderRepo.findAll();
	}

}
