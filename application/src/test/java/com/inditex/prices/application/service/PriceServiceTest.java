package com.inditex.prices.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.inditex.prices.domain.model.Price;

public class PriceServiceTest {

    @Mock
    private PriceService priceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindApplicablePrice() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        Price price = new Price.Builder()
                .brandId(brandId)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(1))
                .priceList(1L)
                .productId(productId)
                .priority(0)
                .price(34.09f)
                .currency("EUR")
                .build();
        Optional<Price> expectedPrice = Optional.of(price);

        when(priceService.findApplicablePrice(productId, brandId, applicationDate)).thenReturn(expectedPrice);

        Optional<Price> actualPrice = priceService.findApplicablePrice(productId, brandId, applicationDate);

        assertTrue(actualPrice.isPresent());
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testFindApplicablePrice_NotFound() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();

        when(priceService.findApplicablePrice(productId, brandId, applicationDate)).thenReturn(Optional.empty());

        Optional<Price> actualPrice = priceService.findApplicablePrice(productId, brandId, applicationDate);

        assertFalse(actualPrice.isPresent());
    }
}