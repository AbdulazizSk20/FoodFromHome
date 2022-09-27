package com.app.dto;

import java.time.LocalDateTime;

import com.app.pojos.Customer;
import com.app.pojos.HomeMaker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderDTO{
	
	private Integer id;	
	private String amount; // amount
	private String orderId;
	private String paymentId;
	private String receipt;
	private String status;
	private LocalDateTime dateTime;
	private Customer customerId;
	private HomeMaker homeMakerId;	
}
