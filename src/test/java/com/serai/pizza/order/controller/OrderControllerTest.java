package com.serai.pizza.order.controller;

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

import com.serai.pizza.order.model.OrderRequest;
import com.serai.pizza.order.service.OrderService;

/**
 * @author Jaina
 */

@SpringBootTest
public class OrderControllerTest {

	@Autowired
	OrderController orderController;
	
	@MockBean
    private OrderService orderService;

	@DisplayName("Test OrderController.placeOrder()")
	@Test
	void testPlaceOrder() {
		List<OrderRequest> orderList = new ArrayList<OrderRequest>(
				Arrays.asList(new OrderRequest(1, "Veg Pizza", 1, 500), new OrderRequest(2, "Cheese Pizza", 2, 1000)));
		Mockito.when(orderService.placeOrder(orderList))
	      .thenReturn(true);

		assertThat(orderController.placeOrder(orderList).getBody()).isEqualTo(true);
	}

}
