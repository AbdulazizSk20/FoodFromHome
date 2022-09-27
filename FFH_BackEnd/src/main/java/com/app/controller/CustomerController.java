package com.app.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.app.dto.CustomerDTO;
import com.app.dto.ResponseDTO;
import com.app.pojos.Orders;
import com.app.service.ICustomerService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins="http://localhost:3000")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	@Autowired
	private OrderRepository ordersRepository;
	
	public CustomerController() {
		System.out.println("In ctor of " + getClass());
	}

//	to authenticate user as a: Customer
	@GetMapping("/login/{email}/{pwd}")
	public ResponseEntity<?> authenticateCustomer(@PathVariable String email, @PathVariable String pwd) {

		System.out.println("In Authenticate Customer: " + email + " " + pwd);
//		if no error, httpStatus code -> ok
//		in case of  any error, it is handled in service layer and accordingly httpStatus code is sent (Global Exc Handler)
		return ResponseEntity.ok(service.authenticateCustomer(email, pwd));
	}

//	to signup a new customer
	@PostMapping("/signup")
	public ResponseEntity<?> signupNewCustomer(@RequestBody /*@Valid*/ CustomerDTO custDTO) {

		System.out.println("In customer signup" + custDTO);
		CustomerDTO newCustomer = service.signUpCustomer(custDTO);
		if (newCustomer == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.ok(newCustomer);
//		return ResponseEntity.ok(new ResponseDTO<	>(newCustomer));
	}

//	to return list of all Customers
	@GetMapping("/getAllCustomers")
	public ResponseEntity<?> getAllCustomers() {

		System.out.println("In getAllCustomers() ");
		return ResponseEntity.ok(service.getAllCustomers());
	}

	// to return Customer details by ID
	@GetMapping("{CustId}")
	public ResponseEntity<?> getCustById(@PathVariable int CustId) {

		return ResponseEntity.ok(service.getCustById(CustId));
	}

//	to delete a Customer by ID
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCustById(@PathVariable int id) {

		return ResponseEntity.ok(new ResponseDTO<>(service.deleteCustById(id)));
	}

//	to update Customer details
	@PutMapping
	public ResponseEntity<?> updateCustDetails(@RequestBody CustomerDTO Cust) {

		return ResponseEntity.ok(service.updateCustDetails(Cust));
	}

//	to add homemaker
	@PutMapping("/add-homemaker/{custId}/{hmId}")
	public ResponseEntity<?> addMyHomeMaker(@PathVariable String hmId, @PathVariable String custId) {

		return ResponseEntity.ok(service.addMyHomeMaker(Integer.parseInt(custId), Integer.parseInt(hmId)));
	}

//	to get homeMaker details for a customer
	@GetMapping("/getMyHomeMaker/{custId}")
	public ResponseEntity<?> getMyHomeMaker(@PathVariable String custId) {

		return ResponseEntity.ok(service.getMyHomeMaker(Integer.parseInt(custId)));
	}

//	to remove a homeMaker for a customer
	@DeleteMapping("/removeMyHomeMaker/{custId}")
	public ResponseEntity<?> removeMyHomeMaker(@PathVariable String custId) {

		return ResponseEntity.ok(service.removeMyHomeMaker(Integer.parseInt(custId)));
	}

//	to add a package  plan and plan type for a customer
	@PutMapping("/updatePackage/{planType}/{pack}")
	public ResponseEntity<?> updatePackage(@PathVariable String planType, @PathVariable String pack,
			@RequestBody CustomerDTO customerDTO) {

		return ResponseEntity.ok(service.updatePackage(planType, pack, customerDTO));
	}

	@PostMapping("/create_order/{custId}/{homeMakerId}") 
	public String createOrder(@PathVariable String custId, @PathVariable String homeMakerId,
			@RequestBody Map<String, Object> data ,Principal principal) throws Exception {
		System.out.println("in payment order");
		System.out.println("Receipt no: " +data.get("receipt"));
		int amt = Integer.parseInt(data.get("amount").toString()); // taking data

		// razor pay
		RazorpayClient client = new RazorpayClient("rzp_test_wUqZzqgwq0QV5o", "67tidmwHy3GcfbvGBRlyqKYE");

		JSONObject ob = new JSONObject();
		ob.put("amount", amt * 100); // converting amount into paise
		ob.put("currency", "INR");
		ob.put("receipt", "txn_"+data.get("receipt"));

		// creating new order
		Order order = client.Orders.create(ob); // Order for razorpayAPI
		System.out.println(order);

		// save order to db

		Orders tiffinOrders = new Orders(); // Orders from pojos

		tiffinOrders.setAmount(order.get("amount") + ""); // order -->razorpay ,+ "" for making string
		tiffinOrders.setOrderId(order.get("id")); // order_no_id
		tiffinOrders.setPaymentId(null);
		tiffinOrders.setDateTime(LocalDateTime.now());
		tiffinOrders.setStatus("unsuccessful");
		tiffinOrders.setReceipt(order.get("receipt"));
		tiffinOrders.setCustomerId(Integer.parseInt(custId));
		tiffinOrders.setHomeMakerId(Integer.parseInt(homeMakerId));
		
		this.ordersRepository.save(tiffinOrders); // saving details
		System.out.println(tiffinOrders);
		// sending this order to client (converting order(json) to string)
		return order.toString();
	}
	
	@PostMapping("/update_order")
	public ResponseEntity<?> updateOrder(@RequestBody Map<String, Object> data) {
		// taking updated data from frontend server updating data
		Orders tiffinOrders = this.ordersRepository.findByOrderId(data.get("order_id").toString());
		// getting order(tiffinOrders) from orderId

		tiffinOrders.setPaymentId(data.get("payment_id").toString());
		tiffinOrders.setStatus(data.get("status").toString());

		this.ordersRepository.save(tiffinOrders);

		System.out.println(data);

		return ResponseEntity.ok("done"); // messeage
	}
	
	@GetMapping("/getAllOrders/{custId}")
	public ResponseEntity<?> getAllOrders(@PathVariable String custId) {
		System.out.println("in get All Orders");
		return ResponseEntity.ok(new ResponseDTO<>(ordersRepository.getAllOrdersForCustomer(Integer.parseInt(custId))));
	}
}
