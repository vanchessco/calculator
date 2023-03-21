package org.example.client.feign;


import org.example.client.feign.error.ErrorDecoderMessage;
import org.example.dto.calculator.CalculatorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "rest", fallbackFactory = ErrorDecoderMessage.class)
public interface CalculatorFeignClient {

    @PostMapping(path = "/api/v1/calc", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CalculatorDTO> getCalc(@RequestBody CalculatorDTO calculator);
}
