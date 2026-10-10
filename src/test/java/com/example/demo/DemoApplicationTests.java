
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFilterProductsByMaxPrice() throws Exception {
        mockMvc.perform(get("/api/products").param("maxPrice", "1000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Mouse"))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void shouldFilterByCategoryAndMaxPrice() throws Exception {
        mockMvc.perform(get("/api/products")
                        .param("category", "electronics")
                        .param("maxPrice", "1000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Mouse"));
    }
}
