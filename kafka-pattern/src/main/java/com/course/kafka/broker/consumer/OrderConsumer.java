package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "t.commodity.order")
    public void listen(OrderMessage message)
    {
        var totalItemAmount  = message.getPrice() * message.getQuantity();
        log.info("processing order {} , item {} , credit card Number {},total amount for this item is {} ",
                message.getOrderNumber() ,
                message.getItemName(),
                message.getCreditCardNumber(),
                totalItemAmount);
    }

}
