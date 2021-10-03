package com.alura.curso.kafka.service.fraud.detector;

import java.math.BigDecimal;

public class Order {
	
	private final String userID;
	private final String orderID;
	private final BigDecimal amount;
	
	public Order(String userID, String orderID, BigDecimal amount) {
		this.userID = userID;
		this.orderID = orderID;
		this.amount = amount;
	}
	
	

}
