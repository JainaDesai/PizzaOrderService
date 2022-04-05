package com.serai.pizza.order.service;

import java.util.List;

import com.serai.pizza.order.model.OrderRequest;

/**
 * @author Jaina
 */

public interface IOrderService {

	public Boolean placeOrder(List<OrderRequest> orderRequest);

}
