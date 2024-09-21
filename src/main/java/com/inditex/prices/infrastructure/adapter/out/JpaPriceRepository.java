package com.inditex.prices.infrastructure.adapter.out;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.prices.application.mapper.PriceMapper;
import com.inditex.prices.core.model.Price;
import com.inditex.prices.domain.port.out.PriceRepository;
import com.inditex.prices.exception.PriceServiceException;
import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JpaPriceRepository implements PriceRepository {

	private final SpringDataPriceRepository springDataPriceRepository;

	public JpaPriceRepository(SpringDataPriceRepository springDataPriceRepository) {
		this.springDataPriceRepository = springDataPriceRepository;
	}

	@Override
	public Optional<Price> findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
	        Long productId, Long brandId, LocalDateTime applicationDate) {
		log.info("Executing JpaPriceRepository");
	    try {
	        PriceEntity priceEntity = springDataPriceRepository
	                .findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
	                        productId, brandId, applicationDate, applicationDate)
	                .orElse(null);
	        log.info("Leaving JpaPriceRepository");
	        return Optional.ofNullable(PriceMapper.INSTANCE.priceEntityToPrice(priceEntity));
	    } catch (Exception e) {
	        throw new PriceServiceException("Database error while fetching price", e);
	    }
	}


}
