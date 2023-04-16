package com.course.kafka.api.request;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

	private String orderLocation;

	private String creditCardNumber;

	private List<OrderItemRequest> items;

}
