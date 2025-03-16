package com.inditex.pruebaTecnica;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.time.format.DateTimeFormatter;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String BASE_URL = "/api/prices";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    void test1_pedido_14_jun_10h() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("applicationDate", "2020-06-14 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceAmount").value(35.50))
                .andExpect(jsonPath("$.priceList").value(1));
    }

    @Test
    void test2_pedido_14_jun_16h() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("applicationDate", "2020-06-14 16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceAmount").value(25.45))
                .andExpect(jsonPath("$.priceList").value(2));
    }

    @Test
    void test3_pedido_14_jun_21h() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("applicationDate", "2020-06-14 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceAmount").value(35.50))
                .andExpect(jsonPath("$.priceList").value(1));
    }

    @Test
    void test4_pedido_15_jun_10h() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("applicationDate", "2020-06-15 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceAmount").value(30.50))
                .andExpect(jsonPath("$.priceList").value(3));
    }

    @Test
    void test5_pedido_16_jun_21h() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("applicationDate", "2020-06-16 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceAmount").value(38.95))
                .andExpect(jsonPath("$.priceList").value(4));
    }
}
