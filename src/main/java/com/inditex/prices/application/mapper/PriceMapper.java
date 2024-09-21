package com.inditex.prices.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.inditex.prices.core.model.Price;
import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    PriceEntity priceToPriceEntity(Price price);
    Price priceEntityToPrice(PriceEntity priceDto);
}
