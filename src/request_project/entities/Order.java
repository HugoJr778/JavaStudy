package request_project.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import request_project.enums.OrderStatus;

public class Order {

	private Date moment;
	private Client client;
	private OrderStatus status;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public double totalPrice() {
		double total = 0;
		for(OrderItem order : orderItem) {
			total += order.subTotal();
		}
		return total;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		this.orderItem.remove(orderItem);
	}
	
	public OrderItem getIndexOrderItem(int index) {
		return orderItem.get(index);
	} 

	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}