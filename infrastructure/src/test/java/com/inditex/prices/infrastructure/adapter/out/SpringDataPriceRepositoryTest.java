package com.inditex.prices.infrastructure.adapter.out;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class SpringDataPriceRepositoryTest {
    
    @Autowired
    private SpringDataPriceRepository springDataPriceRepository;
    
    @Test
    @DisplayName("Test findTopByProductIdAndBrandIdAndDate method")
    void testFindTopByProductIdAndBrandIdAndDate() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        
        PriceEntity priceEntity = PriceEntity.builder()
        .id(1L)
        .brandId(brandId)
        .startDate(applicationDate.minusDays(1))
        .endDate(applicationDate.plusDays(1))
        .productId(productId)
        .priority(1)
        .price(100.0f)
        .currency("EUR")
        .priceList(1L)
        .build();
        
        
        springDataPriceRepository.save(priceEntity);
        
        Optional<PriceEntity> foundEntity = springDataPriceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);
        assertTrue(foundEntity.isPresent());
    }
}