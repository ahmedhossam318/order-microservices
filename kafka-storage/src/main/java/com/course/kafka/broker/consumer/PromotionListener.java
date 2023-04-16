package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.DiscountMessage;
import com.course.kafka.broker.message.PromotionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@KafkaListener(topics = "t.commodity.promotion")
public class PromotionListener {
    @KafkaHandler
    public void listenDiscount(DiscountMessage message)
    {
        log.info("processing discount {}", message);
    }
    @KafkaHandler
    public void listenPromotion(PromotionMessage message)
    {
        log.info("processing promotion {}", message);
    }
    @KafkaHandler(isDefault = true)
    public void listenDefault(Object message)
    {
        log.warn("Received unknown message type: {}", message);
    }

}
