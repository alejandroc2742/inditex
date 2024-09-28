package com.inditex.prices.domain.port.out;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.inditex.prices.domain.model.Price;

public class PriceRepositoryTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceRepositoryTest priceRepositoryTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test finding top price by product ID, brand ID, and date")
    public void testFindTopByProductIdAndBrandIdAndDate() {
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
        
        when(priceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate))
            .thenReturn(Optional.of(price));

        Optional<Price> result = priceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);

        assertTrue(result.isPresent());
        assertEquals(price, result.get());
    }

    @Test
    @DisplayName("Test finding top price by product ID, brand ID, and date when not found")
    public void testFindTopByProductIdAndBrandIdAndDate_NotFound() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        
        when(priceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate))
            .thenReturn(Optional.empty());

        Optional<Price> result = priceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);

        assertFalse(result.isPresent());
    }
}