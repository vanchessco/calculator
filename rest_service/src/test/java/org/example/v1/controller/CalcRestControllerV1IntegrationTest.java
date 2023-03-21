package org.example.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.Rest;
import org.example.domain.calculator.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Rest.class)
@AutoConfigureMockMvc
class CalcRestControllerV1IntegrationTest {

    private static final String URL_V1 = "/api/v1";
    private static Calculator calculator;
    private static ObjectMapper mapper;
    @LocalServerPort
    private Integer port;
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
        mapper = new ObjectMapper();
        //to avoid InvalidDefinitionException: Java 8 date/time type
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    void calculatePositive() throws Exception {
        calculator.setExpression("312.2/10*(sin(1000)+(min(10,1)*123/2)-log(1555))/tan(674)+cos(2.123)*logB(2,10)-logD(213132)");
        mockMvc
                .perform(post(URL_V1 + "/calc").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(calculator)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", is("-1604.8991271536224")));

    }

    @Test
    void calculateNegative() throws Exception {
        calculator.setExpression("");
        mockMvc
                .perform(post(URL_V1 + "/calc").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(calculator)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Missing expression")));

    }


}