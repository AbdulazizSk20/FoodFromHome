package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.OrderRepository;
import com.app.dto.HomeMakerDTO;
import com.app.dto.ResponseDTO;
import com.app.service.IHomeMakerService;

@RestController
@RequestMapping("/homemakers")
@CrossOrigin
public class HomeMakerController {

	@Autowired
	private IHomeMakerService service;
	@Autowired
	private OrderRepository ordersRepository;

	public HomeMakerController() {
		System.out.println("In ctor of " + getClass());
	}

//	to authenticate user as : HomeMaker
	@GetMapping("/login/{email}/{pwd}")
	public ResponseEntity<?> authenticateHomeMaker(@PathVariable String email, @PathVariable String pwd) {
//		if no error, httpStatus code -> ok
//		in case of  any error, it is handled in service layer and accordingly httpStatus code is sent (Global Exc Handler)

		return ResponseEntity.ok(service.authenticateHomeMaker(email, pwd));
//		try {
//			return ResponseEntity.ok(service.authenticateHomeMaker(email, pwd));
//
//		} catch (Exception e) {
//			System.out.println("err in Authenticate HomeMaker  " + e);
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}

//	to return list of all HomeMakers
	@GetMapping("/get-all-home-makers")
	public ResponseEntity<?> getAllHomeMakers() {
		System.out.println("In getAllHomeMakers() ");
		return ResponseEntity.ok(service.getAllHomeMakers());
	}

//	to return HomeMaker details by ID
	@GetMapping("/getHomeMaker/{HomeMakerId}")
	public ResponseEntity<?> getHomeMakerById(@PathVariable int HomeMakerId) {
		return ResponseEntity.ok(service.getHomeMakerById(HomeMakerId));
	}

//	to delete a HomeMaker by ID
	@DeleteMapping("/deleteHomeMaker/{id}")
	public ResponseEntity<?> deleteHomeMakerById(@PathVariable int id) {
		return ResponseEntity.ok(new ResponseDTO<>(service.deleteHomeMakerById(id)));
	}

//	to signup a new HomeMaker
	@PostMapping("/signup")
	public ResponseEntity<?> signupNewHomeMaker(@RequestBody HomeMakerDTO homeMakerDTO) {
		return ResponseEntity.ok(service.signUpHomeMaker(homeMakerDTO));
	}

//	to update HomeMaker details
	@PutMapping("/updateUserDetails")
	public ResponseEntity<?> updateHomeMakerDetails(@RequestBody HomeMakerDTO homeMakerDTO) {
		System.out.println("ID: " + homeMakerDTO.getId());
		return ResponseEntity.ok(service.updateHomeMakerDetails(homeMakerDTO));
	}

//	to get list of customers for a homemaker
	@GetMapping("/getMyCustomers/{hmId}")
	public ResponseEntity<?> getMyCustomers(@PathVariable String hmId) {
		return ResponseEntity.ok(service.getMyCustomers(Integer.parseInt(hmId)));
	}

//	to get list of all HomeMakers from given city
//	fetching data of customers as well..even though fetch type is lazy???????????????
	@GetMapping("/cities/{city}")
	public ResponseEntity<?> getHomeMakersByCity(@PathVariable String city) {
		return ResponseEntity.ok(service.homeMakersByCity(city));
	}

//	to get list of all distinct cities
	@GetMapping("/distinctcities")
	public ResponseEntity<?> getAllCities() {
		return ResponseEntity.ok(service.getAllCities());
	}
	
//	to get details of all orders for a homemaker
//	@GetMapping("/getAllOrders/{hmId}")
//	public ResponseEntity<?> getAllOrders(@PathVariable String hmId){
//		System.out.println("in get all orders: "+hmId);
//		return ResponseEntity.ok(service.getAllOrdersForHomeMaker( Integer.parseInt(hmId)));
//	}
	
	@GetMapping("/getAllOrders/{hmId}")
	public ResponseEntity<?> getAllOrders(@PathVariable String hmId) {
		System.out.println("in get All Orders");
		return ResponseEntity.ok(new ResponseDTO<>(ordersRepository.getAllOrdersForHomeMaker(Integer.parseInt(hmId))));
	}
	
	

}
