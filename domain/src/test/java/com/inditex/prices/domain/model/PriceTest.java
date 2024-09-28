package com.inditex.prices.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {
    
    @Test
    @DisplayName("Test Brand ID")
    public void testBrandId() {
        Long expectedBrandId = 1L;
        Price price = new Price.Builder()
        .brandId(expectedBrandId)
        .build();
        
        assertEquals(expectedBrandId, price.getBrandId());
    }
    
    @Test
    @DisplayName("Test Start Date")
    public void testStartDate() {
        LocalDateTime expectedStartDate = LocalDateTime.now();
        Price price = new Price.Builder()
        .startDate(expectedStartDate)
        .build();
        
        assertEquals(expectedStartDate, price.getStartDate());
    }
    
    @Test
    @DisplayName("Test End Date")
    public void testEndDate() {
        LocalDateTime expectedEndDate = LocalDateTime.now().plusDays(1);
        Price price = new Price.Builder()
        .endDate(expectedEndDate)
        .build();
        
        assertEquals(expectedEndDate, price.getEndDate());
    }
    
    @Test
    @DisplayName("Test Price List")
    public void testPriceList() {
        Long expectedPriceList = 2L;
        Price price = new Price.Builder()
        .priceList(expectedPriceList)
        .build();
        
        assertEquals(expectedPriceList, price.getPriceList());
    }
    
    @Test
    @DisplayName("Test Product ID")
    public void testProductId() {
        Long expectedProductId = 3L;
        Price price = new Price.Builder()
        .productId(expectedProductId)
        .build();
        
        assertEquals(expectedProductId, price.getProductId());
    }
    
    @Test
    @DisplayName("Test Priority")
    public void testPriority() {
        Integer expectedPriority = 1;
        Price price = new Price.Builder()
        .priority(expectedPriority)
        .build();
        
        assertEquals(expectedPriority, price.getPriority());
    }
    
    @Test
    @DisplayName("Test Price")
    public void testPrice() {
        Float expectedPrice = 29.99f;
        Price price = new Price.Builder()
        .price(expectedPrice)
        .build();
        
        assertEquals(expectedPrice, price.getPrice());
    }
    
    @Test
    @DisplayName("Test Currency")
    public void testCurrency() {
        String expectedCurrency = "EUR";
        Price price = new Price.Builder()
        .currency(expectedCurrency)
        .build();
        
        assertEquals(expectedCurrency, price.getCurrency());
    }
    
    @Test
    @DisplayName("Test Full Builder")
    public void testFullBuilder() {
        Long expectedBrandId = 1L;
        LocalDateTime expectedStartDate = LocalDateTime.now();
        LocalDateTime expectedEndDate = LocalDateTime.now().plusDays(1);
        Long expectedPriceList = 2L;
        Long expectedProductId = 3L;
        Integer expectedPriority = 1;
        Float expectedPrice = 29.99f;
        String expectedCurrency = "EUR";
        
        Price price = new Price.Builder()
        .brandId(expectedBrandId)
        .startDate(expectedStartDate)
        .endDate(expectedEndDate)
        .priceList(expectedPriceList)
        .productId(expectedProductId)
        .priority(expectedPriority)
        .price(expectedPrice)
        .currency(expectedCurrency)
        .build();
        
        assertEquals(expectedBrandId, price.getBrandId());
        assertEquals(expectedStartDate, price.getStartDate());
        assertEquals(expectedEndDate, price.getEndDate());
        assertEquals(expectedPriceList, price.getPriceList());
        assertEquals(expectedProductId, price.getProductId());
        assertEquals(expectedPriority, price.getPriority());
        assertEquals(expectedPrice, price.getPrice());
        assertEquals(expectedCurrency, price.getCurrency());
    }
}