package com.alura.curso.kafka.service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.alura.curso.kafka.common.kafka.KafkaDispatcher;

public class NewOrderMain {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
       try(var orderDispatcher = new KafkaDispatcher<Order>()) {
    	   try(var emailDispatcher = new KafkaDispatcher<String>()) {
    		   for (int i = 0; i < 10; i++) {
    			   
					var userID = UUID.randomUUID().toString();
					var orderID = UUID.randomUUID().toString();
					var amount = new BigDecimal(Math.random() * 5000 + 1);
					
					var order = new Order(userID, orderID, amount);
					orderDispatcher.send("ECOMMERCE_NEW_ORDER", userID, order);
					
					var email = "Bem Vindo! Estamos processando sua compra!";
					emailDispatcher.send("ECOMMERCE_SEND_EMAIL", userID, email);
           }
       }
    }
}


}
