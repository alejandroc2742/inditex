package com.inditex.prices.infrastructure.adapter.out;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {

    Optional<PriceEntity> findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long productId, Long brandId, LocalDateTime startDate, LocalDateTime endDate);
}
