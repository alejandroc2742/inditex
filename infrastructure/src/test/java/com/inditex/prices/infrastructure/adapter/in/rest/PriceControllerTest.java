package com.inditex.prices.infrastructure.adapter.in.rest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inditex.prices.application.service.PriceService;
import com.inditex.prices.domain.model.Price;



@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPriceFound() throws Exception {
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
        when(priceService.findApplicablePrice(productId, brandId, applicationDate)).thenReturn(Optional.of(price));

        mockMvc.perform(get("/prices")
                .param("productId", productId.toString())
                .param("brandId", brandId.toString())
                .param("applicationDate", applicationDate.toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPriceNotFound() throws Exception {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();
        when(priceService.findApplicablePrice(productId, brandId, applicationDate)).thenReturn(Optional.empty());

        mockMvc.perform(get("/prices")
                .param("productId", productId.toString())
                .param("brandId", brandId.toString())
                .param("applicationDate", applicationDate.toString()))
                .andExpect(status().isNotFound());
    }
}