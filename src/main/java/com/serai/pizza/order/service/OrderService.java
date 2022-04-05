package com.serai.pizza.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.serai.pizza.order.model.OrderRequest;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Jaina
 */

@Service
@Slf4j
public class OrderService implements IOrderService {
	
	@Autowired
	RestTemplate restTemnplate;
	
	@Override
	public Boolean placeOrder(List<OrderRequest> orderRequest) {
		log.info("Inside placeOrder() of OrderService");
		String url = "http://localhost:8091/persistOrder";
		ResponseEntity<Boolean> result = restTemnplate.postForEntity(url, orderRequest, Boolean.class);
		return result.getBody();
	}
	

}
