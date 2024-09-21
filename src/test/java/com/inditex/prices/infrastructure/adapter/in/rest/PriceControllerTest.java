package com.inditex.prices.infrastructure.adapter.in.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.prices.application.service.PriceService;
import com.inditex.prices.core.model.Price;

public class PriceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    private final String productId = "35455";
    private final String brandId = "1";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }

    // Mock del objeto Price que será devuelto por el servicio
    private Price getMockPrice() {
        return new Price.Builder()
            .brandId(Long.parseLong(brandId))
            .productId(Long.parseLong(productId))
            .priceList(1L)
            .priority(1)
            .price(new BigDecimal("35.50"))
            .currency("EUR")
            .startDate(LocalDateTime.parse("2020-06-14T00:00:00", formatter))
            .endDate(LocalDateTime.parse("2020-12-31T23:59:59", formatter))
            .build();
    }

    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void testFindPriceAt1000On14thForProduct35455() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00", formatter);
        when(priceService.findApplicablePrice(Long.parseLong(productId), Long.parseLong(brandId), applicationDate))
            .thenReturn(Optional.of(getMockPrice()));

        mockMvc.perform(get("/prices")
                .param("productId", productId)
                .param("brandId", brandId)
                .param("applicationDate", applicationDate.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value("35.5"));
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void testFindPriceAt1600On14thForProduct35455() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T16:00:00", formatter);
        when(priceService.findApplicablePrice(Long.parseLong(productId), Long.parseLong(brandId), applicationDate))
            .thenReturn(Optional.of(getMockPrice()));

        mockMvc.perform(get("/prices")
                .param("productId", productId)
                .param("brandId", brandId)
                .param("applicationDate", applicationDate.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value("35.5"));
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void testFindPriceAt2100On14thForProduct35455() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T21:00:00", formatter);
        when(priceService.findApplicablePrice(Long.parseLong(productId), Long.parseLong(brandId), applicationDate))
            .thenReturn(Optional.of(getMockPrice()));

        mockMvc.perform(get("/prices")
                .param("productId", productId)
                .param("brandId", brandId)
                .param("applicationDate", applicationDate.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value("35.5"));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    void testFindPriceAt1000On15thForProduct35455() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15T10:00:00", formatter);
        when(priceService.findApplicablePrice(Long.parseLong(productId), Long.parseLong(brandId), applicationDate))
            .thenReturn(Optional.of(getMockPrice()));

        mockMvc.perform(get("/prices")
                .param("productId", productId)
                .param("brandId", brandId)
                .param("applicationDate", applicationDate.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value("35.5"));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    void testFindPriceAt2100On16thForProduct35455() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-16T21:00:00", formatter);
        when(priceService.findApplicablePrice(Long.parseLong(productId), Long.parseLong(brandId), applicationDate))
            .thenReturn(Optional.of(getMockPrice()));

        mockMvc.perform(get("/prices")
                .param("productId", productId)
                .param("brandId", brandId)
                .param("applicationDate", applicationDate.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.price").value("35.5"));
    }
}
