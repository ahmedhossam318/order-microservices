package com.course.kafka.api.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse {

	private String orderNumber;

}
