package com.course.kafka.broker.message;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PromotionMessage {
    private String promotionCode;
}
