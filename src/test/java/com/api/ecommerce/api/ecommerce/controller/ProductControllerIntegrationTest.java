package com.api.ecommerce.api.ecommerce.controller;


import com.api.ecommerce.api.ecommerce.repository.PriceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PriceRepository repository;

    @Captor
    ArgumentCaptor<LocalDateTime> argumentsStartDate;
    @Captor
    ArgumentCaptor<Integer> productId;
    ArgumentCaptor<Integer> BrandId;

    @Test
    @DisplayName("Return HTTPCode 400 when Price information not exist")
    void shouldReturnHttpCode404WhenStartDateIsInvalid() throws Exception{
        String exceptionParam = "Data Not Found";

        mvc.perform(MockMvcRequestBuilders.get("/product?startDate=2020-06-14T16:00:00&productId=35455&brandId=N", exceptionParam)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }




}
