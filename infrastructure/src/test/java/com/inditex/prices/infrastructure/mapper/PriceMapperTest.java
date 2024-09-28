
    package com.inditex.prices.infrastructure.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.inditex.prices.domain.model.Price;
import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;

public class PriceMapperTest {

        private final PriceMapper priceMapper = PriceMapper.INSTANCE;

        @Test
        public void testPriceEntityToPrice() {
            // Arrange
            PriceEntity priceEntity = PriceEntity.builder()
                    .id(1L)
                    .brandId(1L)
                    .startDate(LocalDateTime.now())
                    .endDate(LocalDateTime.now().plusDays(1))
                    .priceList(1L)
                    .productId(1001L)
                    .priority(1)
                    .price(29.99f)
                    .currency("EUR")
                    .build();

            // Act
            Price price = priceMapper.priceEntityToPrice(priceEntity);

            // Assert
            assertNotNull(price);
            assertEquals(priceEntity.getId(), price.getId());
            assertEquals(priceEntity.getBrandId(), price.getBrandId());
            assertEquals(priceEntity.getStartDate(), price.getStartDate());
            assertEquals(priceEntity.getEndDate(), price.getEndDate());
            assertEquals(priceEntity.getPriceList(), price.getPriceList());
            assertEquals(priceEntity.getProductId(), price.getProductId());
            assertEquals(priceEntity.getPriority(), price.getPriority());
            assertEquals(priceEntity.getPrice(), price.getPrice());
            assertEquals(priceEntity.getCurrency(), price.getCurrency());
        }

        @Test
        public void testPriceToPriceEntity() {
            // Arrange
            Price price = new Price.Builder()
                    .id(1L)
                    .brandId(1L)
                    .startDate(LocalDateTime.now())
                    .endDate(LocalDateTime.now().plusDays(1))
                    .priceList(1L)
                    .productId(1001L)
                    .priority(1)
                    .price(29.99f)
                    .currency("EUR")
                    .build();

            // Act
            PriceEntity priceEntity = priceMapper.priceToPriceEntity(price);

            // Assert
            assertNotNull(priceEntity);
            assertEquals(price.getId(), priceEntity.getId());
            assertEquals(price.getBrandId(), priceEntity.getBrandId());
            assertEquals(price.getStartDate(), priceEntity.getStartDate());
            assertEquals(price.getEndDate(), priceEntity.getEndDate());
            assertEquals(price.getPriceList(), priceEntity.getPriceList());
            assertEquals(price.getProductId(), priceEntity.getProductId());
            assertEquals(price.getPriority(), priceEntity.getPriority());
            assertEquals(price.getPrice(), priceEntity.getPrice());
            assertEquals(price.getCurrency(), priceEntity.getCurrency());
        }
    }
