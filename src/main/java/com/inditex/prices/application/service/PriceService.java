package com.inditex.prices.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.prices.core.model.Price;

@Service
public interface PriceService {

	public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
