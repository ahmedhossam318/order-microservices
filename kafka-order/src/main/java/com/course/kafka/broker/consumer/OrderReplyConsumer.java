package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderReplyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderReplyConsumer {

	@KafkaListener(topics = "t.commodity.order-reply")
	public void listen(OrderReplyMessage message) {
		log.info("Reply message received : {} " + message);
	}

}
