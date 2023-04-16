package com.course.kafka.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	@Id
	@GeneratedValue
	private int orderId;

	@Column(nullable = false, length = 20)
	private String orderNumber;

	@Column(nullable = false, length = 20)
	private String creditCardNumber;

	@Column(nullable = false, length = 200)
	private String orderLocation;

	@Column(nullable = false)
	private LocalDateTime orderDateTime;

	@OneToMany(mappedBy = "order")
	List<OrderItem> Items;

}
