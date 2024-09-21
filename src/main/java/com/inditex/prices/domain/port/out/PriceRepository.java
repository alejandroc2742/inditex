package com.inditex.prices.domain.port.out;

import java.time.LocalDateTime;
import java.util.Optional;

import com.inditex.prices.core.model.Price;

public interface PriceRepository {
	Optional<Price> findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long productId, Long brandId, LocalDateTime applicationDate);
}