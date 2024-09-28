package com.inditex.prices;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class PricesApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

    @Test
    void testApplicationContext() {
        assertThat(applicationContext).isNotNull();
    }

}