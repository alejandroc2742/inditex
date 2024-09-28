package com.inditex.prices.infrastructure.adapter.out.persistence.entity;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PriceEntityTest {
    
    private PriceEntity priceEntity;
    
    @BeforeEach
    public void setUp() {
        priceEntity = PriceEntity.builder()
        .brandId(1L)
        .startDate(LocalDateTime.now())
        .endDate(LocalDateTime.now().plusDays(1))
        .productId(1L)
        .priority(1)
        .price(100.0f)
        .currency("EUR")
        .build();
    }
    
    @Test
    public void testPriceEntityCreation() {
        assertNotNull(priceEntity);
        assertEquals(1L, priceEntity.getBrandId());
        assertNotNull(priceEntity.getStartDate());
        assertNotNull(priceEntity.getEndDate());
        assertEquals(1L, priceEntity.getProductId());
        assertEquals(1, priceEntity.getPriority());
        assertEquals(100.0f, priceEntity.getPrice());
        assertEquals("EUR", priceEntity.getCurrency());
    }
    
    @Test
    public void testSettersAndGetters() {
        priceEntity.setBrandId(2L);
        priceEntity.setStartDate(LocalDateTime.now().plusDays(2));
        priceEntity.setEndDate(LocalDateTime.now().plusDays(3));
        priceEntity.setProductId(2L);
        priceEntity.setPriority(2);
        priceEntity.setPrice(200.0f);
        priceEntity.setCurrency("USD");
        
        assertEquals(2L, priceEntity.getBrandId());
        assertNotNull(priceEntity.getStartDate());
        assertNotNull(priceEntity.getEndDate());
        assertEquals(2L, priceEntity.getProductId());
        assertEquals(2, priceEntity.getPriority());
        assertEquals(200.0f, priceEntity.getPrice());
        assertEquals("USD", priceEntity.getCurrency());
    }
}