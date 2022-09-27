package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	
//	to get all orders
	List<Orders> findAll();	
//	to get order details by orderID
	Orders findByOrderId(String orderId);
//	to get details of all orders for a customer
	@Query("select o from Orders o where o.customerId=:custId")
	List<Orders> getAllOrdersForCustomer(int custId);
//	to get details of all orders for a homemaker
	@Query("select o from Orders o where o.homeMakerId=:hmId")
	List<Orders> getAllOrdersForHomeMaker(int hmId);

}
