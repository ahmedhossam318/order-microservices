package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderMessage;
import com.course.kafka.broker.message.OrderReplyMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderListenerTwo {
    @KafkaListener(topics = "t.commodity.order")
    @SendTo("t.commodity.order-reply")
    public OrderReplyMessage listen(ConsumerRecord<String , OrderMessage> consumerRecord)
    {
        var headers = consumerRecord.headers();
        var orderMessage = consumerRecord.value();

        log.info("processing order {} , item {} , credit card number {} ",
                orderMessage.getOrderNumber(),
                orderMessage.getItemName() ,
                orderMessage.getCreditCardNumber());
        log.info("Headers are : ");
        headers.forEach(h -> log.info("key {} , value {} ", h.key() , new String(h.value())));

        var bonusPercentage = Double.parseDouble(new String(headers.lastHeader("surpriseBonus").value()));
        var bonusAmount = (bonusPercentage / 100) * orderMessage.getPrice() * orderMessage.getQuantity();

        log.info("surprise bonus is {} ",bonusAmount);
        var replyMessage = new OrderReplyMessage();
        replyMessage.setReplyMessage("order " + orderMessage.getOrderNumber() + "item " + orderMessage.getItemName() + " processed ");
        return replyMessage;
    }
}
