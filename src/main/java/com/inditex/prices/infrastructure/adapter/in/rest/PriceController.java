package com.inditex.prices.infrastructure.adapter.in.rest;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.prices.application.service.PriceService;
import com.inditex.prices.core.model.Price;

@RestController
public class PriceController {

	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@GetMapping("/prices")
	public ResponseEntity<Price> getPrice(@RequestParam Long productId, @RequestParam Long brandId,
			@RequestParam LocalDateTime applicationDate) {
		Optional<Price> price = priceService.findApplicablePrice(productId, brandId, applicationDate);
		return price.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
