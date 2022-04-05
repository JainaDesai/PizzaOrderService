package com.serai.pizza.order.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.serai.pizza.order.model.OrderRequest;

/**
 * @author Jaina
 */

@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	OrderService orderService;
	
	@MockBean
	RestTemplate restTemplate;
	
	@DisplayName("Test OrderService.placeOrder()")
	@Test
	void testPlaceOrder() {
		List<OrderRequest> orderList = new ArrayList<OrderRequest>(
				Arrays.asList(new OrderRequest(1, "Veg Pizza", 1, 500), new OrderRequest(2, "Cheese Pizza", 2, 1000)));
		Mockito.when(restTemplate.postForEntity("http://localhost:8091/persistOrder", orderList, Boolean.class)).thenReturn(new ResponseEntity<>(true, HttpStatus.CREATED));

		assertThat(orderService.placeOrder(orderList)).isEqualTo(true);
	}
}
