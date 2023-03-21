package org.example.v2.service;

import org.example.dto.calculator.CalculatorDTO;
import reactor.core.publisher.Mono;

public interface ReactiveCalculatorService {

    Mono<CalculatorDTO> compute(CalculatorDTO calculatorDTO);
}
