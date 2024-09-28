package com.inditex.prices.infrastructure.adapter.out;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.prices.application.exception.PriceServiceException;
import com.inditex.prices.domain.model.Price;
import com.inditex.prices.domain.port.out.PriceRepository;
import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;
import com.inditex.prices.infrastructure.mapper.PriceMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JpaPriceRepository implements PriceRepository {
	
	private final SpringDataPriceRepository springDataPriceRepository;
	
	public JpaPriceRepository(SpringDataPriceRepository springDataPriceRepository) {
		this.springDataPriceRepository = springDataPriceRepository;
	}
	
	@Override
	public Optional<Price> findTopByProductIdAndBrandIdAndDate(
	Long productId, Long brandId, LocalDateTime applicationDate) {
		log.info("Executing JpaPriceRepository");
		try {
			PriceEntity priceEntity = springDataPriceRepository
			.findTopByProductIdAndBrandIdAndDate(
			productId, brandId, applicationDate)
			.orElse(null);
			return Optional.ofNullable(PriceMapper.INSTANCE.priceEntityToPrice(priceEntity));
		} catch (Exception e) {
			throw new PriceServiceException("Database error while fetching price", e);
		}
	}
	
	
}
