package com.inditex.prices.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.inditex.prices.application.exception.PriceNotFoundException;
import com.inditex.prices.domain.model.Price;
import com.inditex.prices.domain.port.out.PriceRepository;


public class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindApplicablePrice_Success() {
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

        Optional<Price> result = priceServiceImpl.findApplicablePrice(productId, brandId, applicationDate);

        assert(result.isPresent());
        assert(result.get().equals(price));
    }

    @Test
    public void testFindApplicablePrice_NotFound() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        
        when(priceRepository.findTopByProductIdAndBrandIdAndDate(productId, brandId, applicationDate))
                .thenReturn(Optional.empty());

        assertThrows(PriceNotFoundException.class, () -> {
            priceServiceImpl.findApplicablePrice(productId, brandId, applicationDate);
        });
    }
}