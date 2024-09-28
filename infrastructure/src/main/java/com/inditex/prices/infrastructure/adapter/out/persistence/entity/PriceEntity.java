package com.inditex.prices.infrastructure.adapter.out.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long brandId;

	private LocalDateTime startDate;
	private LocalDateTime endDate;

	private Long priceList;
	private Long productId;

	private Integer priority;
	private Float price;
	private String currency;
}
