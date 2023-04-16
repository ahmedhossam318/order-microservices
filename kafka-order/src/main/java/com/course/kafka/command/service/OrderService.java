package com.course.kafka.command.service;

import com.course.kafka.api.request.OrderRequest;
import com.course.kafka.command.action.OrderAction;
import com.course.kafka.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderAction orderAction;

	public String saveOrder(OrderRequest request) {
		// 1. convert orderRequest to order
		Order order = orderAction.convertToOrder(request);
		// save the order in the database
		orderAction.saveToDatabase(order);
		// 3. flatten the item & order as kafka messages, and publish
		order.getItems().forEach(orderAction::publishToKafka);
		// return order number (auto generated)
		return order.getOrderNumber();
	}

}
