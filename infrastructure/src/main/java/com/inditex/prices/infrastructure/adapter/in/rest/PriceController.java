package com.inditex.prices.infrastructure.adapter.in.rest;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.prices.application.service.PriceService;
import com.inditex.prices.domain.model.Price;
import com.inditex.prices.gen.infrastructure.adapter.in.rest.PricesApi;
import com.inditex.prices.gen.infrastructure.adapter.out.persistence.entity.PriceDTO;
import com.inditex.prices.infrastructure.mapper.PriceMapper;

@RestController
public class PriceController implements PricesApi{

	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@GetMapping("/prices")
	@Override
	public ResponseEntity<PriceDTO> pricesGet(@RequestParam Long productId, @RequestParam Long brandId,
				@RequestParam LocalDateTime applicationDate) {
		Optional<Price> price = priceService.findApplicablePrice(productId, brandId, applicationDate);
		return price.map(p -> ResponseEntity.ok(PriceMapper.INSTANCE.priceToPriceDTO(p)))
					.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
