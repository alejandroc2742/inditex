package com.inditex.prices.infrastructure.adapter.out;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.inditex.prices.application.exception.PriceServiceException;
import com.inditex.prices.domain.model.Price;
import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;




public class JpaPriceRepositoryTest {
    
    @Mock
    private SpringDataPriceRepository springDataPriceRepository;
    
    @InjectMocks
    private JpaPriceRepository jpaPriceRepository;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testFindTopByProductIdAndBrandIdAndDate_Success() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        
        
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setPriority(1); 
        priceEntity.setProductId(productId);
        priceEntity.setBrandId(brandId);
        priceEntity.setPrice(35.5f); 
        priceEntity.setCurrency("EUR");
        
        when(springDataPriceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate))
        .thenReturn(Optional.of(priceEntity));
        
        
        Optional<Price> result = jpaPriceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);
        
        
        assertThat(result).isPresent();
        assertThat(result.get().getProductId()).isEqualTo(productId);
        assertThat(result.get().getPrice()).isEqualTo(priceEntity.getPrice());
    }
    
    @Test
    void testFindTopByProductIdAndBrandIdAndDate_NotFound() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        
        when(springDataPriceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate))
        .thenReturn(Optional.empty());
        
        Optional<Price> result = jpaPriceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);
        
        assertThat(result).isNotPresent();
    }
    
    @Test
    void testFindTopByProductIdAndBrandIdAndDate_Exception() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        
        when(springDataPriceRepository.findTopByProductIdAndBrandIdAndDate(any(), any(), any()))
        .thenThrow(new RuntimeException("Database error"));
        
        assertThrows(PriceServiceException.class, () -> {
            jpaPriceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);
        });
    }
}