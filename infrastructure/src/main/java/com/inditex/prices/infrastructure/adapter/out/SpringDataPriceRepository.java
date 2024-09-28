package com.inditex.prices.infrastructure.adapter.out;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {
        
        @Query(value = "SELECT * FROM PRICES p " +
        "WHERE p.product_id = :productId " +
        "AND p.brand_id = :brandId " +
        "AND :queryDate BETWEEN p.start_date AND p.end_date " +
        "ORDER BY p.priority DESC " +
        "LIMIT 1", nativeQuery = true)
        Optional<PriceEntity> findTopByProductIdAndBrandIdAndDate(
        Long productId,
        Long brandId,
        LocalDateTime queryDate);
}