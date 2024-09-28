package com.inditex.prices.domain.port.out;

import java.time.LocalDateTime;
import java.util.Optional;

import com.inditex.prices.domain.model.Price;

public interface PriceRepository {
	Optional<Price> findTopByProductIdAndBrandIdAndDate(Long productId, Long brandId, LocalDateTime applicationDate);
}