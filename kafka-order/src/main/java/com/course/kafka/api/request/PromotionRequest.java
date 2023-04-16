package com.course.kafka.api.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PromotionRequest {

	private String promotionCode;

}
