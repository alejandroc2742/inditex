package com.inditex.prices.infrastructure.adapter.out;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

import com.inditex.prices.application.mapper.PriceMapper;
import com.inditex.prices.core.model.Price;
import com.inditex.prices.exception.PriceServiceException;
import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;

class JpaPriceRepositoryTest {

    @InjectMocks
    private JpaPriceRepository jpaPriceRepository;

    @Mock
    private SpringDataPriceRepository springDataPriceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findTopByProductIdAndBrandId_found() {
        // Arrange
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();

        PriceEntity priceEntity = PriceEntity.builder()
                .brandId(brandId)
                .productId(productId)
                .priceList(1L)
                .priority(1)
                .price(new BigDecimal("35.50"))
                .currency("EUR")
                .startDate(applicationDate.minusDays(1))
                .endDate(applicationDate.plusDays(1))
                .build();

        when(springDataPriceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate))
                .thenReturn(Optional.of(priceEntity));

        // Act
        Optional<Price> result = jpaPriceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate);

        // Assert
        assertTrue(result.isPresent());
        Price expectedPrice = PriceMapper.INSTANCE.priceEntityToPrice(priceEntity);
        Price actualPrice = result.get();
        assertEquals(expectedPrice.getProductId(), actualPrice.getProductId());
        assertEquals(expectedPrice.getBrandId(), actualPrice.getBrandId());
        assertEquals(expectedPrice.getPrice(), actualPrice.getPrice());
        assertEquals(expectedPrice.getCurrency(), actualPrice.getCurrency());
        assertEquals(expectedPrice.getStartDate(), actualPrice.getStartDate());
        assertEquals(expectedPrice.getEndDate(), actualPrice.getEndDate());
        assertEquals(expectedPrice.getPriority(), actualPrice.getPriority());
    }


    @Test
    void findTopByProductIdAndBrandId_notFound() {
        // Arrange
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();

        when(springDataPriceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate))
                .thenReturn(Optional.empty());

        // Act
        Optional<Price> result = jpaPriceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate);

        // Assert
        assertFalse(result.isPresent());
        verify(springDataPriceRepository).findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate);
    }

    @Test
    void findTopByProductIdAndBrandId_throwsException() {
        // Arrange
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();

        when(springDataPriceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate))
                .thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        PriceServiceException exception = assertThrows(PriceServiceException.class, () -> {
            jpaPriceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                    productId, brandId, applicationDate);
        });

        assertEquals("Database error while fetching price", exception.getMessage());
        verify(springDataPriceRepository).findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate);
    }
}
