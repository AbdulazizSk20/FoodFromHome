package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString //(exclude = {"customer","homeMaker"})
@NoArgsConstructor
@Entity
//@Table(name = "orders", uniqueConstraints = @UniqueConstraint(columnNames = { "customer_id", "home_maker_id" }))
@Table(name = "orders")
public class Orders extends BaseEntity {

	@Column(length = 30, name = "order_amount_paise")
	private String amount; // amount

	@Column(length = 30)
	private String orderId;

	@Column(length = 30)
	private String paymentId;

	@Column(length = 30)
	private String receipt;

	@Column(length = 30)
	private String status;

	private LocalDateTime dateTime;

	/*
	 * // Order HAS-A Customer (i.e linked with Customer)
	 * 
	 * @ManyToOne(cascade = CascadeType.ALL) // (fetch = FetchType.LAZY) // => 1
	 * Customer can have multiple orders // Customer 1<-----* Order
	 * 
	 * @JoinColumn(name = "customer_id") // to specify name of the FK col to
	 * hibernate private Customer customer;
	 * 
	 * // Order HAS-A HomeMaker (i.e linked with HomeMaker)
	 * 
	 * @ManyToOne(cascade = CascadeType.ALL) // (fetch = FetchType.LAZY)// => 1
	 * HomeMaker can have multiple orders
	 * 
	 * @JoinColumn(name = "home_maker_id") // HomeMaker 1 <----- * Order private
	 * HomeMaker homeMaker;
	 */

	@Column(length = 30)
	private int customerId;

	@Column(length = 30)
	private int homeMakerId;

}
