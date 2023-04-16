package com.course.kafka.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue
	private int orderItemId;

	@Column(nullable = false, length = 200)
	private String itemName;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false)
	private int quantity;

	@JoinColumn(name = "order_id")
	@ManyToOne
	private Order order;

}
