package com.inditex.prices.infrastructure.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.inditex.prices.domain.model.Price;
import com.inditex.prices.gen.infrastructure.adapter.out.persistence.entity.PriceDTO;
import com.inditex.prices.infrastructure.adapter.out.persistence.entity.PriceEntity;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "currency", target = "currency")
    PriceEntity priceToPriceEntity(Price price);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "currency", target = "currency")
    Price priceEntityToPrice(PriceEntity priceEntity);


    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "currency", target = "currency")
     PriceDTO priceToPriceDTO(Price price);
}