package com.serai.pizza.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serai.pizza.order.model.OrderRequest;
import com.serai.pizza.order.service.IOrderService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jaina
 */

@RestController
@Slf4j
@RequestMapping("/pizzaShop")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@PostMapping(value = "/order")
    ResponseEntity<?> placeOrder(@RequestBody List<OrderRequest> orderRequest) {
		log.info("Inside placeOrder() of OrderController");
        try {
        	Boolean response = orderService.placeOrder(orderRequest);
            if (response != null) {
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to place order.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
