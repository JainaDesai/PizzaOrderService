package com.serai.pizza.order.model;

/**
 * @author Jaina
 */

public class OrderRequest {
    int requestId;
    String item;
    int quantity;
    long price;

	public OrderRequest(int requestId, String item, int quantity, long price) {
        this.requestId = requestId;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    
    public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}