package com.course.kafka.broker.message;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DiscountMessage {
    private String discountCode;
    private int discount;
}
