package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.PromotionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class PromotionProducer {

	@Autowired
	KafkaTemplate<String, PromotionMessage> kafkaTemplate;

	public void publish(PromotionMessage message) {
		try {
			var sendResult = kafkaTemplate.send("t.commodity.promotion", message).get();
			log.info("send Result success for message {}", sendResult.getProducerRecord().value());

		}
		catch (InterruptedException | ExecutionException e) {
			log.error("Error publishing {} , cause {} ", message, e.getMessage());
		}
	}

}
