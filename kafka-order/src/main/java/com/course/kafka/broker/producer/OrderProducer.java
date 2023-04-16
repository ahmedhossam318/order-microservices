package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderProducer {

	@Autowired
	KafkaTemplate<String, OrderMessage> kafkaTemplate;

	private ProducerRecord<String, OrderMessage> buildProducerRecord(OrderMessage message) {
		int surpriseBonus = StringUtils.startsWithIgnoreCase(message.getOrderLocation(), "A") ? 25 : 15;
		List<Header> headers = new ArrayList<>();
		var surpriseBonusHeader = new RecordHeader("surpriseBonus", Integer.toString(surpriseBonus).getBytes());
		headers.add(surpriseBonusHeader);
		return new ProducerRecord<>("t.commodity.order", null, message.getOrderNumber(), message, headers);
	}

	public void publish(OrderMessage orderMessage) {
		var producerRecord = buildProducerRecord(orderMessage);
		kafkaTemplate.send(producerRecord).whenCompleteAsync((result, ex) -> {
			if (ex != null) {
				log.info("Order {} , item {} failed to publish, because {}", orderMessage.getOrderNumber(),
						orderMessage.getItemName(), ex.getMessage());
				// do something else like insert log in database etc ...
			}
			else {

				log.info("Order {} , item {} published successfully", orderMessage.getOrderNumber(),
						orderMessage.getItemName());

				System.out.println("Message sent successfully. Offset: " + result.getRecordMetadata().offset());
			}
		});
		log.info("Just a dummy message for Order {} , item {} published successfully", orderMessage.getOrderNumber(),
				orderMessage.getItemName());
	}

}
