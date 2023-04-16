package com.course.kafka.api.request;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemRequest {

	private String itemName;

	private int price;

	private int quantity;

}
