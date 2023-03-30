package com.utn.lab4.tpfinal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.lab4.tpfinal.business.BusinessProduct;
import com.utn.lab4.tpfinal.business.impl.ProductBusinessImple;
import com.utn.lab4.tpfinal.dto.AltaCategoryDto;
import com.utn.lab4.tpfinal.dto.AltaProductDto;
import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.model.ProductType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.utn.lab4.tpfinal.model.ProductType.celulares;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessProduct businessProduct;

    @Test
    public void createProductTest() throws Exception {
        AltaProductDto dto = new AltaProductDto();
        dto.setName("test");
        dto.setType(celulares);
        dto.setDescription("test");
        dto.setBrand("test");

        when(businessProduct.createProduct(dto)).thenReturn(new Product());

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("El producto fue creado con exito"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

