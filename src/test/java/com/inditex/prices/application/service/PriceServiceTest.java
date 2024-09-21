package com.inditex.prices.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.inditex.prices.core.model.Price;
import com.inditex.prices.domain.port.out.PriceRepository;
import com.inditex.prices.exception.PriceNotFoundException;

class PriceServiceTest {

    @InjectMocks
    private PriceServiceImpl priceService;

    @Mock
    private PriceRepository priceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findApplicablePrice_found() {
        // Arrange
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        
        Price price = new Price.Builder()
                .brandId(brandId)
                .productId(productId)
                .priceList(1L)
                .priority(1)
                .price(new BigDecimal("35.50"))
                .currency("EUR")
                .startDate(applicationDate.minusDays(1))
                .endDate(applicationDate.plusDays(1))
                .build();

        when(priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate))
                .thenReturn(Optional.of(price));

        // Act
        Optional<Price> result = priceService.findApplicablePrice(productId, brandId, applicationDate);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(price.getPrice(), result.get().getPrice());
        verify(priceRepository).findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate);
    }

    @Test
    void findApplicablePrice_notFound() {
        // Arrange
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();

        when(priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate))
                .thenReturn(Optional.empty());

        // Act & Assert
        PriceNotFoundException thrown = assertThrows(PriceNotFoundException.class, () -> {
            priceService.findApplicablePrice(productId, brandId, applicationDate);
        });

        assertEquals("No applicable price found for productId: 1 and brandId: 1", thrown.getMessage());
        verify(priceRepository).findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate);
    }
}
