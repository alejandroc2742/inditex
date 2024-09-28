package com.inditex.prices.application.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.prices.application.exception.PriceNotFoundException;
import com.inditex.prices.domain.model.Price;
import com.inditex.prices.domain.port.out.PriceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

	private final PriceRepository priceRepository;

	public PriceServiceImpl(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	@Override
	public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate) {
		log.info("Executing findApplicablePrice for productId: {}, and brandId {}", productId, brandId);
		Optional<Price> priceEntity = priceRepository
				.findTopByProductIdAndBrandIdAndDate(
						productId, brandId, applicationDate);
		if (priceEntity.isEmpty()) {
			throw new PriceNotFoundException(
					"No applicable price found for productId: " + productId + " and brandId: " + brandId);
		}
		log.info("Leaving findApplicablePrice");
		return priceEntity;
	}
}
